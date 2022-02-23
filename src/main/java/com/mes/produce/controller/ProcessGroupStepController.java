package com.mes.produce.controller;

import com.mes.produce.entity.ProcessGroupStep;
import com.mes.produce.service.ProcessGroupStepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ProcessGroupStepController {
	private final ProcessGroupStepService processGroupStepService;

	public ProcessGroupStepController(ProcessGroupStepService processGroupStepService) {
		this.processGroupStepService = processGroupStepService;
	}

	@GetMapping(value = "/processGroupStep")
	public ResponseEntity<List<ProcessGroupStep>> getAllByParam() {
		List<ProcessGroupStep> processGroupStepList = processGroupStepService.findByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(processGroupStepList);
	}

	@PostMapping(value = "/processGroupStep", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewProcessGroupStep(@RequestPart(value = "processGroupStep") ProcessGroupStep processGroupStep) {
		processGroupStepService.saveProcessGroupStep(processGroupStep);
		return ok().build();
	}

	@PutMapping(value = "processGroupStep")
	public ResponseEntity<Void> updateProcessGroupStep(@RequestBody ProcessGroupStep processGroupStep) {
		processGroupStepService.updateProcessGroupStep(processGroupStep);
		return ok().build();
	}

	@DeleteMapping(value="processGroupStep/{processGroupStepIndexNo}")
	public ResponseEntity<Void> deleteProcessGroupStep(@PathVariable(name = "processGroupStepIndexNo") Long processGroupStepIndexNo){
		processGroupStepService.deleteProcessGroupStep(processGroupStepIndexNo);
		return ok().build();
	}
}
