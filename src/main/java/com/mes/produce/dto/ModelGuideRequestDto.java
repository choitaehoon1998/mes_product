package com.mes.produce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelGuideRequestDto {
	private Long modelIndexNo;
	private Long revisionNo;
	private String isLastRevision;
	private String guideType;
}
