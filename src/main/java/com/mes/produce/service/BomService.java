package com.mes.produce.service;

import com.mes.produce.dto.BomResponseDto;
import com.mes.produce.entity.Bom;
import com.mes.produce.entity.BomItem;
import com.mes.produce.repository.BomItemRepository;
import com.mes.produce.repository.BomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BomService {
	private final BomRepository bomRepository;
	private final BomItemRepository bomItemRepository;

	public BomService(BomRepository bomRepository, BomItemRepository bomItemRepository) {
		this.bomRepository = bomRepository;
		this.bomItemRepository = bomItemRepository;
	}

	public List<BomResponseDto> findBomByParam(HashMap<String, Object> hashMap) {
		return bomRepository.findAllByParam(hashMap);
	}

	public void saveBom(Bom bom) {
		bom.setBomVersionNumber(1L);
		bom.setIsLastVersion("Y");
		bomRepository.save(bom);
	}

	public void updateBom(Bom bom) {
		if (bom != null && bom.getIndexNo() != null && bomRepository.existsById(bom.getIndexNo())) {
			Bom dbBom = bomRepository.getById(bom.getIndexNo());

			bom.setIsLastVersion("N");
			bom.setBomPartNumber(dbBom.getBomPartNumber());
			bom.setBomVersionNumber(dbBom.getBomVersionNumber());
			bomRepository.save(bom);

			Bom newBom = new Bom();
			BeanUtils.copyProperties(bom, newBom, "bomVersionNumber", "indexNo");
			newBom.setBomVersionNumber(bom.getBomVersionNumber() + 1);
			newBom.setIsLastVersion("Y");
			newBom = bomRepository.save(newBom);
			List<BomItem> bomItemList = dbBom.getBomItemList();

			for (BomItem bomElement : bomItemList) {
				BomItem newBomItem = new BomItem();
				BeanUtils.copyProperties(bomElement, newBomItem, "indexNo");
				newBomItem.setBom(newBom);
				bomItemRepository.save(newBomItem);
			}

		}
	}

	public void deleteBom(Long bomIndexNo) {
		if (bomIndexNo != null && bomRepository.existsById(bomIndexNo)) {
			bomRepository.deleteById(bomIndexNo);
		}
	}

	public void deleteBomItemList(Long bomIndexNo) {
		if (bomIndexNo != null && bomRepository.existsById(bomIndexNo)) {
			Bom bom = bomRepository.findById(bomIndexNo).get();
			List<BomItem> bomItemList = bom.getBomItemList();
			bomItemRepository.deleteAll(bomItemList);
		}
	}
}
