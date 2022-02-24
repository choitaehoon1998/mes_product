package com.mes.produce.service;

import com.mes.produce.dto.BomItemResponseDto;
import com.mes.produce.entity.BomItem;
import com.mes.produce.repository.BomItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BomItemService {
	private final BomItemRepository bomItemRepository;

	public BomItemService(BomItemRepository bomItemRepository) {
		this.bomItemRepository = bomItemRepository;
	}

	public List<BomItemResponseDto> findByParam(HashMap<String, Object> hashMap) {
		return bomItemRepository.findByParam(hashMap);
	}

	public void saveBomItem(BomItem bomItem) {
		bomItemRepository.save(bomItem);
	}

	public void updateBom(BomItem bomItem) {
		if (bomItem != null && bomItem.getIndexNo() != null && bomItemRepository.existsById(bomItem.getIndexNo())) {
			bomItemRepository.save(bomItem);
		}
	}

	public void deleteBom(Long bomItemIndexNo) {
		if (bomItemIndexNo != null && bomItemRepository.existsById(bomItemIndexNo)) {
			bomItemRepository.deleteById(bomItemIndexNo);
		}
	}
}
