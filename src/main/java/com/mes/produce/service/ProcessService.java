package com.mes.produce.service;

import com.mes.produce.entity.Process;
import com.mes.produce.repository.ProcessRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProcessService {
	private final ProcessRepository processRepository;

	public ProcessService(ProcessRepository processRepository) {
		this.processRepository = processRepository;
	}

	public List<Process> findByParam(HashMap<String, Object> hashMap) {
		return processRepository.findByParam(hashMap);
	}

	public void saveNewProcess(Process process) {
		processRepository.save(process);
	}

	public void updateProcess(Process process) {
		if (process != null && process.getIndexNo() != null && processRepository.existsById(process.getIndexNo())) {
			processRepository.save(process);
		}
	}

	public void deleteProcess(Long processIndexNo) {
		if (processIndexNo != null && processRepository.existsById(processIndexNo)) {
			processRepository.deleteById(processIndexNo);
		}
	}
}
