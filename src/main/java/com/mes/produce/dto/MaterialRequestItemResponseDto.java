package com.mes.produce.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MaterialRequestItemResponseDto {
	private Long materialRequestIndexNo;
	private Long materialRequestItemIndexNo;
	private Long seq;
	private Long requestQuantity;
	private Long requestItemCd;
	private String formStatus;
	private Date outDate;
	private Date inDate;

}
