package com.mes.produce.repository;

import com.mes.produce.entity.ModelGuide;

import java.util.HashMap;
import java.util.List;

public interface ModelGuideQueryRepository {
	List<ModelGuide> findByParam(HashMap<String, Object> hashMap);
}
