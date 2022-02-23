package com.mes.produce.repository.impl;

import com.mes.produce.entity.ProcessGroup;
import com.mes.produce.repository.ProcessGroupQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QProcessGroup.processGroup;

@RequiredArgsConstructor
public class ProcessGroupRepositoryImpl implements ProcessGroupQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<ProcessGroup> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(processGroup).fetch();
	}
}
