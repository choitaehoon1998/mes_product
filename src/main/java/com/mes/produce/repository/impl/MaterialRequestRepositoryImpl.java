package com.mes.produce.repository.impl;

import com.mes.produce.entity.MaterialRequest;

import static com.mes.produce.entity.QMaterialRequest.materialRequest;

import com.mes.produce.repository.MaterialRequestQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class MaterialRequestRepositoryImpl implements MaterialRequestQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<MaterialRequest> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(materialRequest).fetch();
	}

}
