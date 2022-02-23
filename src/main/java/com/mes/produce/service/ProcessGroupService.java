package com.mes.produce.service;

import com.mes.produce.dto.responseDto.ProcessGroupResponseDto;
import com.mes.produce.entity.ProcessGroup;
import com.mes.produce.repository.ProcessGroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProcessGroupService {
	private final ProcessGroupRepository processGroupRepository;

	public ProcessGroupService(ProcessGroupRepository processGroupRepository) {
		this.processGroupRepository = processGroupRepository;
	}

	public List<ProcessGroupResponseDto> findByParam(HashMap<String, Object> hashMap) {
		List<ProcessGroupResponseDto> processGroupResponseDtoList = new ArrayList<>();
		processGroupRepository.findByParam(hashMap).forEach(e ->
				processGroupResponseDtoList.add(new ProcessGroupResponseDto(e)));
		return processGroupResponseDtoList;
	}

	public void saveProcessGroup(ProcessGroup processGroup) {
		processGroupRepository.save(processGroup);
	}

	public void updateProcessGroup(ProcessGroup processGroup) {
		if (processGroup != null && processGroup.getIndexNo() != null && processGroupRepository.existsById(processGroup.getIndexNo())) {
			processGroupRepository.save(processGroup);
		}
	}

	public void deleteProcessGroup(Long processGroupIndexNo) {
		if (processGroupIndexNo != null && processGroupRepository.existsById(processGroupIndexNo)) {
			processGroupRepository.deleteById(processGroupIndexNo);
		}
	}
}
