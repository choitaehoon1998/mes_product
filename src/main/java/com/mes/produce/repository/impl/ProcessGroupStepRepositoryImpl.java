package com.mes.produce.repository.impl;

import com.mes.produce.entity.ProcessGroupStep;
import com.mes.produce.repository.ProcessGroupStepQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QProcessGroupStep.processGroupStep;

@RequiredArgsConstructor
public class ProcessGroupStepRepositoryImpl implements ProcessGroupStepQueryRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<ProcessGroupStep> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(processGroupStep).fetch();
	}
}
