package com.mes.produce.service;

import com.mes.produce.dto.ModelResponseDto;
import com.mes.produce.entity.Model;
import com.mes.produce.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
	private final ModelRepository modelRepository;

	public ModelService(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}

	public List<ModelResponseDto> findAllModel() {
		return modelRepository.findAllModel();
	}
}
