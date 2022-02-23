package com.mes.produce.repository;

import com.mes.produce.entity.ProcessGroupStep;

import java.util.HashMap;
import java.util.List;

public interface ProcessGroupStepQueryRepository {
	List<ProcessGroupStep> findByParam(HashMap<String, Object> hashMap);
}
