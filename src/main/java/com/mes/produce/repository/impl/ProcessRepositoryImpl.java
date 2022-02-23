package com.mes.produce.repository.impl;

import com.mes.produce.entity.Process;
import com.mes.produce.repository.ProcessQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.mes.produce.entity.QProcess.process;

@RequiredArgsConstructor
public class ProcessRepositoryImpl implements ProcessQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Process> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(process).fetch();
	}
}
