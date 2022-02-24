package com.mes.produce.repository;

import com.mes.produce.entity.MaterialRequest;

import java.util.HashMap;
import java.util.List;

public interface MaterialRequestQueryRepository {
	List<MaterialRequest> findAllByParam(HashMap<String, Object> hashMap);
}
