package com.mes.produce.repository;

import com.mes.produce.entity.Process;

import java.util.HashMap;
import java.util.List;

public interface ProcessQueryRepository {
	List<Process> findByParam(HashMap<String, Object> hashMap);
}
