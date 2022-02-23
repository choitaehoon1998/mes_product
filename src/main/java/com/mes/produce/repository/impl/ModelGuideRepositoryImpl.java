package com.mes.produce.repository.impl;

import com.mes.produce.entity.ModelGuide;
import com.mes.produce.repository.ModelGuideQueryRepository;
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
		return queryFactory.selectFrom(modelGuide).fetch();
	}
}
