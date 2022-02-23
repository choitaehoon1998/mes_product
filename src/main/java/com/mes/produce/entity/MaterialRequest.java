package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MATERIAL_REQUEST")
public class MaterialRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Integer indexNo;

	@Column(name = "FORM_DATE", length = 50)
	private String formDate;

	@Column(name = "REQUEST_USER_INDEX_NO")
	private Integer requestUserIndexNo;

	@Column(name = "TOTAL_STATUS", length = 1)
	private String totalStatus;

	@Column(name = "REQUEST_TYPE", length = 1)
	private String requestType;

}