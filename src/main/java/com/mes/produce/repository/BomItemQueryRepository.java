package com.mes.produce.repository;

import com.mes.produce.dto.BomItemResponseDto;

import java.util.HashMap;
import java.util.List;

public interface BomItemQueryRepository {
	List<BomItemResponseDto> findByParam(HashMap<String, Object> hashMap);
}
