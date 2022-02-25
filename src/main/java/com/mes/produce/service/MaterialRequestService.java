package com.mes.produce.service;

import com.mes.produce.entity.MaterialRequest;
import com.mes.produce.repository.MaterialRequestRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class MaterialRequestService {
	private final MaterialRequestRepository materialRequestRepository;

	public MaterialRequestService(MaterialRequestRepository materialRequestRepository) {
		this.materialRequestRepository = materialRequestRepository;
	}

	public List<MaterialRequest> findAllByParam(HashMap<String, Object> hashMap) {
		return materialRequestRepository.findAllByParam(hashMap);
	}

	public void saveMaterialRequest(MaterialRequest materialRequest) {
		materialRequest.setFormDate(Date.valueOf(LocalDate.now()));
		materialRequestRepository.save(materialRequest);
	}

	public void updateMaterialRequest(MaterialRequest materialRequest) {
		if (materialRequest != null && materialRequest.getIndexNo() != null && materialRequestRepository.existsById(materialRequest.getIndexNo())) {
			materialRequestRepository.save(materialRequest);
		}
	}

	public void deleteMaterialRequest(Long materialRequestIndexNo) {
		if (materialRequestIndexNo != null && materialRequestRepository.existsById(materialRequestIndexNo)) {
			materialRequestRepository.deleteById(materialRequestIndexNo);
		}
	}
}
