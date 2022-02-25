package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "MATERIAL_REQUEST_ITEM"
		, uniqueConstraints = @UniqueConstraint(columnNames = {"MATERIAL_REQUEST_INDEX_NO", "SEQ"}))
public class MaterialRequestItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "MATERIAL_REQUEST_INDEX_NO")
	private MaterialRequest materialRequest;

	@Column(name = "SEQ")
	private Long seq;

	@Column(name = "REQUEST_QUANTITY")
	private Long requestQuantity;

	@Column(name = "REQUEST_ITEM_CD")
	private Long requestItemCd;

	@Column(name = "FORM_STATUS", length = 1)
	private String formStatus;

	@Column(name = "OUT_DATE")
	private Date outDate;

	@Column(name = "IN_DATE")
	private Date inDate;

	@Transient
	private Long materialRequestIndexNo;
}