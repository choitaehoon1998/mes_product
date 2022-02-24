package com.mes.produce.repository;

import com.mes.produce.entity.MaterialRequestItem;

import java.util.HashMap;
import java.util.List;

public interface MaterialRequestItemQueryRepository {
	List<MaterialRequestItem> findAllByParam(HashMap<String, Object> hashMap);
}
