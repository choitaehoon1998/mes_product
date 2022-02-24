package com.mes.produce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BomItemResponseDto {
	private Long bomItemIndexNo;

	private Long bomIndexNo;
	private Long bomVersion;
	private Long bomPartNumber;

	private Long seq;
	private String bomItemName;
	private Long quantity;
	private Long cost;
	private String description;
	private String type;
	private String vendor;
}
