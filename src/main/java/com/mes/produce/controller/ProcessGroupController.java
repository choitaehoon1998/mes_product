package com.mes.produce.controller;

import com.mes.produce.dto.responseDto.ProcessGroupResponseDto;
import com.mes.produce.entity.ProcessGroup;
import com.mes.produce.service.ProcessGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ProcessGroupController {
	private final ProcessGroupService processGroupService;

	public ProcessGroupController(ProcessGroupService processGroupService) {
		this.processGroupService = processGroupService;
	}

	@GetMapping(value = "/processGroup")
	public ResponseEntity<List<ProcessGroupResponseDto>> getAllByParam() {
		List<ProcessGroupResponseDto> processGroupResponseDtoList = processGroupService.findByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(processGroupResponseDtoList);
	}

	@PostMapping(value = "/processGroup", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewProcessGroup(@RequestPart(value = "processGroup") ProcessGroup processGroup) {
		processGroupService.saveProcessGroup(processGroup);
		return ok().build();
	}

	@PutMapping(value = "/processGroup")
	public ResponseEntity<Void> updateProcessGroup(@RequestBody ProcessGroup processGroup) {
		processGroupService.updateProcessGroup(processGroup);
		return ok().build();
	}

	@DeleteMapping(value = "/processGroup/{processGroup}")
	public ResponseEntity<Void> deleteProcessGroup(@PathVariable(value = "processGroup") Long processGroupIndexNo) {
		processGroupService.deleteProcessGroup(processGroupIndexNo);
		return ok().build();
	}
}
