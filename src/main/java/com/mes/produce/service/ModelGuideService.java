package com.mes.produce.service;

import com.mes.produce.Enum.useYn.TrueFalse;
import com.mes.produce.dto.ModelGuideRequestDto;
import com.mes.produce.entity.ModelGuide;
import com.mes.produce.repository.ModelGuideRepository;
import com.mes.produce.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ModelGuideService {
	private final ModelGuideRepository modelGuideRepository;
	private final ModelRepository modelRepository;

	public ModelGuideService(ModelGuideRepository modelGuideRepository, ModelRepository modelRepository) {
		this.modelGuideRepository = modelGuideRepository;
		this.modelRepository = modelRepository;
	}

	public List<ModelGuide> findByParam(HashMap<String, Object> hashMap) {

		return modelGuideRepository.findByParam(hashMap);
	}

	public void saveNewModelGuide(ModelGuideRequestDto modelGuideRequestDto) {
		if (modelGuideRequestDto != null && modelGuideRequestDto.getModelIndexNo() != null && modelRepository.existsById(modelGuideRequestDto.getModelIndexNo())) {
			ModelGuide modelGuide = ModelGuide.builder()
					.model(modelRepository.findById(modelGuideRequestDto.getModelIndexNo()).get())
					.revisionNo(modelGuideRequestDto.getRevisionNo())
					.isLastRevision(modelGuideRequestDto.equals("Y") ? TrueFalse.Y : TrueFalse.N)
					.guideType(modelGuideRequestDto.getGuideType())
					.build();
			modelGuideRepository.save(modelGuide);
		}
	}

	public void updateFileInfoModelGuide(Long modelGuideIndexNo, HashMap<String, String> filePathMap) {
		if (modelGuideIndexNo != null && modelGuideRepository.existsById(modelGuideIndexNo)) {
			ModelGuide modelGuide = modelGuideRepository.getById(modelGuideIndexNo);
			for (String fileName : filePathMap.keySet()) {
				String filePath = filePathMap.get(fileName);
				modelGuide.setFileName(fileName);
				modelGuide.setFilePath(filePath);
			}
			modelGuideRepository.save(modelGuide);
		}
	}
}
