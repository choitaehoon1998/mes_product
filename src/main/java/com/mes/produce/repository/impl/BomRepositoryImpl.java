package com.mes.produce.repository.impl;

import com.mes.produce.dto.BomResponseDto;
import com.mes.produce.repository.BomQueryRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QBom.bom;

@RequiredArgsConstructor
public class BomRepositoryImpl implements BomQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<BomResponseDto> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.select(Projections.fields(BomResponseDto.class,
				bom.indexNo.as("indexNo"),
				bom.bomPartNumber.as("bomPartNumber"),
				bom.bomVersionNumber.as("bomVersionNumber"),
				bom.bomName.as("bomName"),
				bom.isLastVersion.as("isLastVersion"))).from(bom)
				.where(eqIsLastVersion((String) hashMap.get("isLastRevision"))).fetch();
	}

	private BooleanExpression eqIsLastVersion(String isLastVersion) {
		if (isLastVersion.equals("Y")) {
			return bom.isLastVersion.eq("Y");
		}
		return null;
	}
}
