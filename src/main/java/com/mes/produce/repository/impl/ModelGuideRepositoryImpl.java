package com.mes.produce.repository.impl;

import com.mes.produce.entity.ModelGuide;
import com.mes.produce.repository.ModelGuideQueryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QModelGuide.modelGuide;

@RequiredArgsConstructor
public class ModelGuideRepositoryImpl implements ModelGuideQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<ModelGuide> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory
				.selectFrom(modelGuide)
				.where(eqModelIndexNo((Long) hashMap.get("modelIndexNo")))
				.fetch();
	}

	private BooleanExpression eqModelIndexNo(Long modelIndexNo) {
		if (modelIndexNo == null) {
			return null;
		}
		return modelGuide.model.indexNo.eq(modelIndexNo);
	}
}
