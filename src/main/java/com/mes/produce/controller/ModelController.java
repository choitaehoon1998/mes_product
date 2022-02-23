package com.mes.produce.controller;

import com.mes.produce.dto.ModelResponseDto;
import com.mes.produce.entity.Model;
import com.mes.produce.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ModelController {
	private final ModelService modelService;

	public ModelController(ModelService modelService) {
		this.modelService = modelService;
	}

	@GetMapping(value = "/model")
	public ResponseEntity<List<ModelResponseDto>> getAllModel(){
		List<ModelResponseDto> modelList = modelService.findAllModel();
		return ok(modelList);
	}
}
