package com.mes.produce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BomResponseDto {
	private Long indexNo;
	private Long bomPartNumber;
	private Long bomVersionNumber;
	private String bomName;
	private String isLastVersion;
}
