package com.mes.produce.repository.impl;

import com.mes.produce.entity.MaterialRequestItem;
import com.mes.produce.repository.MaterialRequestItemQueryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QMaterialRequestItem.materialRequestItem;

@RequiredArgsConstructor
public class MaterialRequestItemRepositoryImpl implements MaterialRequestItemQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<MaterialRequestItem> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(materialRequestItem)
				.where(eqMaterialRequestIndexNo((Long) hashMap.get("materialRequestIndexNo")))
				.fetch();
	}

	private BooleanExpression eqMaterialRequestIndexNo(Long materialRequestIndexNo) {
		if (materialRequestIndexNo == null) {
			return null;
		}
		return materialRequestItem.materialRequest.indexNo.eq(materialRequestIndexNo);
	}
}
