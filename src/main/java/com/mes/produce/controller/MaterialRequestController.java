package com.mes.produce.controller;

import com.mes.produce.entity.MaterialRequest;
import com.mes.produce.service.MaterialRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class MaterialRequestController {

	private final MaterialRequestService materialRequestService;

	public MaterialRequestController(MaterialRequestService materialRequestService) {
		this.materialRequestService = materialRequestService;
	}

	@GetMapping(value = "/materialRequest")
	public ResponseEntity<List<MaterialRequest>> findAllMaterialRequestByParam() {

		List<MaterialRequest> materialRequestList = materialRequestService.findAllByParam(new HashMap<String, Object>() {{
		}});
		return ok(materialRequestList);
	}

	@PostMapping(value = "/materialRequest", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewMaterialRequest(@RequestPart("materialRequest") MaterialRequest materialRequest) {
		materialRequestService.saveMaterialRequest(materialRequest);
		return ok().build();
	}

	@PutMapping(value="/materialRequest")
	public ResponseEntity<Void> updateMaterialRequest(@RequestBody MaterialRequest materialRequest){
		materialRequestService.updateMaterialRequest(materialRequest);
		return ok().build();
	}

	@DeleteMapping(value="/materialRequest/{materialRequestIndexNo}")
	public ResponseEntity<Void> deleteMaterialRequest(@PathVariable("materialRequestIndexNo")Long materialRequestIndexNo){
		materialRequestService.deleteMaterialRequest(materialRequestIndexNo);
		return ok().build();
	}
}
