package com.mes.produce.repository;

import com.mes.produce.dto.ModelResponseDto;
import com.mes.produce.entity.Model;

import java.util.List;

public interface ModelQueryRepository {
	List<ModelResponseDto> findAllModel();
}
