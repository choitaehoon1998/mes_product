package com.mes.produce.service;

import com.mes.produce.entity.ProcessGroupStep;
import com.mes.produce.repository.ProcessGroupStepRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProcessGroupStepService {
	private final ProcessGroupStepRepository processGroupStepRepository;

	public ProcessGroupStepService(ProcessGroupStepRepository processGroupStepRepository) {
		this.processGroupStepRepository = processGroupStepRepository;
	}

	public List<ProcessGroupStep> findByParam(HashMap<String, Object> hashMap) {
		return processGroupStepRepository.findByParam(hashMap);
	}

	public void saveProcessGroupStep(ProcessGroupStep processGroupStep) {
		processGroupStepRepository.save(processGroupStep);
	}

	public void updateProcessGroupStep(ProcessGroupStep processGroupStep) {
		if (processGroupStep != null && processGroupStep.getIndexNo() != null && processGroupStepRepository.existsById(processGroupStep.getIndexNo())) {
			processGroupStepRepository.save(processGroupStep);
		}
	}

	public void deleteProcessGroupStep(Long processGroupStepIndexNo) {
		if (processGroupStepIndexNo != null && processGroupStepRepository.existsById(processGroupStepIndexNo)) {
			processGroupStepRepository.deleteById(processGroupStepIndexNo);
		}
	}
}
