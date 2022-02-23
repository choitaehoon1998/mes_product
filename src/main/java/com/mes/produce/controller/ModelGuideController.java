package com.mes.produce.controller;

import com.mes.produce.dto.ModelGuideRequestDto;
import com.mes.produce.entity.ModelGuide;
import com.mes.produce.service.FileService;
import com.mes.produce.service.ModelGuideService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ModelGuideController {
	private final ModelGuideService modelGuideService;
	private final FileService fileService;

	public ModelGuideController(ModelGuideService modelGuideService, FileService fileService) {
		this.modelGuideService = modelGuideService;
		this.fileService = fileService;
	}

	@GetMapping(value = "/modelGuide")
	public ResponseEntity<List<ModelGuide>> findAllByParam(@RequestParam(name = "modelIndexNo") Long modelIndexNo) {
		List<ModelGuide> modelGuideList = modelGuideService.findByParam(new HashMap<String, Object>() {{
			put("modelIndexNo", modelIndexNo);
		}});
		return ok(modelGuideList);
	}

	@PostMapping(value = "/modelGuide", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewModelGuide(@RequestPart("modelGuide") ModelGuideRequestDto modelGuideRequestDto) {
		modelGuideService.saveNewModelGuide(modelGuideRequestDto);
		return ok().build();
	}

	@PostMapping(value = "/modelGuideFile", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewFile(@RequestPart("modelGuideIndexNo") Long modelGuideIndexNo,
	                                        @RequestPart("file") MultipartFile file) throws IOException {
		HashMap<String, String> filePathMap = fileService.uploadFile(file);
		modelGuideService.updateFileInfoModelGuide(modelGuideIndexNo,filePathMap);
		return ok().build();
	}
}
