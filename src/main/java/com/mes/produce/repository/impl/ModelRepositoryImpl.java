package com.mes.produce.repository.impl;

import com.mes.produce.dto.ModelResponseDto;
import com.mes.produce.repository.ModelQueryRepository;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.mes.produce.entity.QModel.model;
import static com.mes.produce.entity.QModelGuide.modelGuide;
import static com.querydsl.core.types.ExpressionUtils.count;

@RequiredArgsConstructor
public class ModelRepositoryImpl implements ModelQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<ModelResponseDto> findAllModel() {
		return queryFactory.select(Projections.fields(ModelResponseDto.class,
				model.indexNo.as("indexNo"),
				model.modelName.as("modelName"),
				ExpressionUtils.as(JPAExpressions.select(count(modelGuide.indexNo)).from(modelGuide).where(modelGuide.model
						.eq(model)), "isGuideExist"))).from(model).fetch();

	}
}
