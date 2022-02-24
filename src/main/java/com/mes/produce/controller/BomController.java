package com.mes.produce.controller;

import com.mes.produce.dto.BomResponseDto;
import com.mes.produce.entity.Bom;
import com.mes.produce.service.BomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class BomController {
	private final BomService bomService;

	public BomController(BomService bomService) {
		this.bomService = bomService;
	}

	@GetMapping("/bom")
	private ResponseEntity<List<BomResponseDto>> getAllBomByParam(
			@RequestParam(value = "isLastRevision", defaultValue = "Y", required = false) String isLastRevision) {
		List<BomResponseDto> bomList = bomService.findBomByParam(new HashMap<String, Object>() {{
			put("isLastRevision", isLastRevision);
		}});
		return ok(bomList);
	}

	@PostMapping(value = "/bom", consumes = MULTIPART_FORM_DATA_VALUE)
	private ResponseEntity<Void> saveNewBom(@RequestPart("bom") Bom bom) {
		bomService.saveBom(bom);
		return ok().build();
	}

	@PutMapping(value = "/bom")
	private ResponseEntity<Void> updateBom(@RequestBody Bom bom) {
		bomService.updateBom(bom);
		return ok().build();
	}

	@DeleteMapping(value = "/bom/{bomIndexNo}")
	private ResponseEntity<Void> deleteBom(@PathVariable Long bomIndexNo) {
		bomService.deleteBom(bomIndexNo);
		return ok().build();
	}

	@DeleteMapping(value = "/bom/bomItemList/{bomIndexNo}")
	private ResponseEntity<Void> deleteBomItemList(@PathVariable("bomIndexNo") Long bomIndexNo) {
		bomService.deleteBomItemList(bomIndexNo);
		return ok().build();
	}
}
