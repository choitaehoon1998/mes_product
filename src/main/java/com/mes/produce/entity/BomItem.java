package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BOM_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {"BOM_INDEX_NO","SEQ"}))
public class BomItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "BOM_INDEX_NO")
	private Bom bom;

	@Column(name = "SEQ")
	private Long seq;

	@Column(name = "BOM_ITEM_NAME", length = 2000)
	private String bomItemName;

	@Column(name = "QUANTITY")
	private Long quantity;

	@Column(name = "COST")
	private Long cost;

	@Column(name = "DESCRIPTION", length = 2000)
	private String description;

	@Column(name = "TYPE", length = 5)
	private String type;

	@Column(name = "VENDOR")
	private String vendor;

}