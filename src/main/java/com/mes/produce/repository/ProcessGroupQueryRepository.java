package com.mes.produce.repository;

import com.mes.produce.entity.ProcessGroup;

import java.util.HashMap;
import java.util.List;

public interface ProcessGroupQueryRepository {
	List<ProcessGroup> findByParam(HashMap<String, Object> hashMap);
}
