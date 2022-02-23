package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MATERIAL_REQUEST_ITEM")
public class MaterialRequestItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Integer indexNo;

	@ManyToOne
	@JoinColumn(name = "MATERIAL_REQUEST_INDEX_NO")
	private MaterialRequest materialRequestIndexNo;

	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "REQUEST_QUANTITY")
	private Integer requestQuantity;

	@Column(name = "REQUEST_ITEM_CD")
	private Integer requestItemCd;

	@Column(name = "FORM_STATUS")
	private Integer formStatus;

	@Column(name = "OUT_DATE")
	private Integer outDate;

	@Column(name = "IN_DATE")
	private Integer inDate;

}