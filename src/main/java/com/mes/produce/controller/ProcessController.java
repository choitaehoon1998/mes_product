package com.mes.produce.controller;

import com.mes.produce.entity.Process;
import com.mes.produce.service.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ProcessController {
	private final ProcessService processService;

	public ProcessController(ProcessService processService) {
		this.processService = processService;
	}

	@GetMapping("/process")
	public ResponseEntity<List<Process>> getAllByParam() {
		List<Process> processList = processService.findByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(processList);
	}

	@PostMapping(value = "/process", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewProcess(@RequestPart(value = "process") Process process) {
		processService.saveNewProcess(process);
		return ok().build();
	}

	@PutMapping(value = "/process")
	public ResponseEntity<Void> updateProcess(@RequestBody Process process) {
		processService.updateProcess(process);
		return ok().build();
	}

	@DeleteMapping(value = "/process/{processIndexNo}")
	public ResponseEntity<Void> deleteProcess(@PathVariable(value = "processIndexNo") Long processIndexNo){
		processService.deleteProcess(processIndexNo);
		return ok().build();
	}
}
