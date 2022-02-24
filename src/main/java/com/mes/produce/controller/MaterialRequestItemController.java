package com.mes.produce.controller;

import com.mes.produce.entity.MaterialRequestItem;
import com.mes.produce.service.MaterialRequestItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class MaterialRequestItemController {
	private final MaterialRequestItemService materialRequestItemService;

	public MaterialRequestItemController(MaterialRequestItemService materialRequestItemService) {
		this.materialRequestItemService = materialRequestItemService;
	}

	@GetMapping(value = "/materialRequestItem")
	public ResponseEntity<List<MaterialRequestItem>> getAllByParam(@RequestParam(name = "materialRequestIndexNo", required = false) Long materialRequestIndexNo) {
		List<MaterialRequestItem> materialRequestItemList = materialRequestItemService.findAllByParam(new HashMap<String, Object>() {{
			put("materialRequestIndexNo", materialRequestIndexNo);
		}});
		return ok(materialRequestItemList);
	}

	@PostMapping(value = "/materialRequestItem", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewMaterialRequestItem(@RequestPart("materialRequestItem") MaterialRequestItem materialRequestItem) {
		materialRequestItemService.saveMaterialRequestItem(materialRequestItem);
		return ok().build();
	}

	@PostMapping(value = "/materialRequestItemList", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewMaterialRequestItemList(@RequestPart("materialRequestItemList") List<MaterialRequestItem> materialRequestItemList) {
		materialRequestItemService.saveMaterialRequestItemList(materialRequestItemList);
		return ok().build();
	}

	@PutMapping(value = "/materialRequestItem")
	public ResponseEntity<Void> updateMaterialRequestItem(@RequestBody MaterialRequestItem materialRequestItem) {
		materialRequestItemService.updateMaterialRequestItem(materialRequestItem);
		return ok().build();
	}

	@DeleteMapping(value = "/materialRequestItem/{materialRequestItemIndexNo}")
	public ResponseEntity<Void> deleteMaterialRequestItem(@PathVariable("materialRequestItemIndexNo") Long materialRequestITemIndexNo) {
		materialRequestItemService.deleteMaterialRequestItem(materialRequestITemIndexNo);
		return ok().build();
	}

}
