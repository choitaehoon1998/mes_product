package com.mes.produce.service;

import com.mes.produce.entity.MaterialRequestItem;
import com.mes.produce.repository.MaterialRequestItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialRequestItemService {
	private final MaterialRequestItemRepository materialRequestItemRepository;

	public MaterialRequestItemService(MaterialRequestItemRepository materialRequestItemRepository) {
		this.materialRequestItemRepository = materialRequestItemRepository;
	}

	public List<MaterialRequestItem> findAllByParam(HashMap<String, Object> hashMap) {
		return materialRequestItemRepository.findAllByParam(hashMap);
	}

	public void saveMaterialRequestItem(MaterialRequestItem materialRequestItem) {
		materialRequestItemRepository.save(materialRequestItem);
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
