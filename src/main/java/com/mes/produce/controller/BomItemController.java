package com.mes.produce.controller;

import com.mes.produce.dto.BomItemResponseDto;
import com.mes.produce.entity.BomItem;
import com.mes.produce.service.BomItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class BomItemController {
	private final BomItemService bomItemService;

	public BomItemController(BomItemService bomItemService) {
		this.bomItemService = bomItemService;
	}

	@GetMapping("/bomItem")
	public ResponseEntity<List<BomItemResponseDto>> getAllByParam(@RequestParam(value = "bomIndexNo", required = false) Long bomIndexNo) {
		List<BomItemResponseDto> bomItemList = bomItemService.findByParam(new HashMap<String, Object>() {{
			put("bomIndexNo", bomIndexNo);
		}});
		return ok(bomItemList);
	}

	@PostMapping(value = "/bomItem", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewBom(@RequestPart("bomItem") BomItem bomItem) {
		bomItemService.saveBomItem(bomItem);
		return ok().build();
	}

	@PutMapping(value = "/bomItem")
	public ResponseEntity<Void> updateBom(@RequestBody BomItem bomItem) {
		bomItemService.updateBom(bomItem);
		return ok().build();
	}

	@DeleteMapping(value = "/bomItem/{bomItemIndexNo}")
	public ResponseEntity<Void> deleteBom(@PathVariable("bomItemIndexNo") Long bomItemIndexNo) {
		bomItemService.deleteBom(bomItemIndexNo);
		return ok().build();
	}
}
