package com.mes.produce.service;

import com.mes.produce.dto.MaterialRequestItemResponseDto;
import com.mes.produce.entity.MaterialRequestItem;
import com.mes.produce.repository.MaterialRequestItemRepository;
import com.mes.produce.repository.MaterialRequestRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialRequestItemService {
	private final MaterialRequestItemRepository materialRequestItemRepository;
	private final MaterialRequestRepository materialRequestRepository;

	public MaterialRequestItemService(MaterialRequestItemRepository materialRequestItemRepository, MaterialRequestRepository materialRequestRepository) {
		this.materialRequestItemRepository = materialRequestItemRepository;
		this.materialRequestRepository = materialRequestRepository;
	}

	public List<MaterialRequestItemResponseDto> findAllByParam(HashMap<String, Object> hashMap) {
		return materialRequestItemRepository.findAllByParam(hashMap);
	}

	public void saveMaterialRequestItem(MaterialRequestItem materialRequestItem) {
		if (materialRequestItem != null && materialRequestItem.getMaterialRequestIndexNo() != null && materialRequestRepository.existsById(materialRequestItem.getMaterialRequestIndexNo())) {
			materialRequestItem.setMaterialRequest(materialRequestRepository.findById(materialRequestItem.getMaterialRequestIndexNo()).get());
			materialRequestItemRepository.save(materialRequestItem);
		}
	}


	public void saveMaterialRequestItemList(List<MaterialRequestItem> materialRequestItemList) {
		materialRequestItemRepository.saveAll(materialRequestItemList);
	}

	public void updateMaterialRequestItem(MaterialRequestItem materialRequestItem) {
		if (materialRequestItem != null && materialRequestItem.getIndexNo() != null && materialRequestItemRepository.existsById(materialRequestItem.getIndexNo())) {
			materialRequestItemRepository.save(materialRequestItem);
		}
	}

	public void deleteMaterialRequestItem(Long materialRequestITemIndexNo) {
		if (materialRequestITemIndexNo != null && materialRequestItemRepository.existsById(materialRequestITemIndexNo)) {
			materialRequestItemRepository.deleteById(materialRequestITemIndexNo);
		}
	}


}
