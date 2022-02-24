package com.mes.produce.repository.impl;

import com.mes.produce.dto.BomItemResponseDto;
import com.mes.produce.repository.BomItemQueryRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QBomItem.bomItem;

@RequiredArgsConstructor
public class BomItemRepositoryImpl implements BomItemQueryRepository {
	private final JPAQueryFactory queryFactory;


	@Override
	public List<BomItemResponseDto> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.select(Projections.fields(BomItemResponseDto.class, bomItem.indexNo.as("bomItemIndexNo"),
				bomItem.bom.indexNo.as("bomIndexNo"),
				bomItem.bom.bomVersionNumber.as("bomVersion"),
				bomItem.bom.bomPartNumber.as("bomPartNumber"),
				bomItem.seq.as("seq"),
				bomItem.bomItemName.as("bomItemName"),
				bomItem.quantity.as("quantity"),
				bomItem.cost.as("cost"),
				bomItem.description.as("description"),
				bomItem.type.as("type"),
				bomItem.vendor.as("vendor"))).from(bomItem).where(eqBomIndexNo((Long) hashMap.get("bomIndexNo"))).fetch();
	}

	private BooleanExpression eqBomIndexNo(Long bomIndexNo) {
		if (bomIndexNo == null) {
			return null;
		}
		return bomItem.bom.indexNo.eq(bomIndexNo);
	}
}
