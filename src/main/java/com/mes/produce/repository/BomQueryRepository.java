package com.mes.produce.repository;

import com.mes.produce.dto.BomResponseDto;

import java.util.HashMap;
import java.util.List;

public interface BomQueryRepository {
	List<BomResponseDto> findAllByParam(HashMap<String, Object> hashMap);
}
