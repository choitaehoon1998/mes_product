package com.mes.produce.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BOM", uniqueConstraints = @UniqueConstraint(columnNames = {"BOM_PART_NUMBER", "BOM_VERSION_NUMBER"}))
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Bom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@Column(name = "BOM_PART_NUMBER", nullable = false)
	private Long bomPartNumber;

	@Column(name = "BOM_VERSION_NUMBER", nullable = false)
	private Long bomVersionNumber;

	@Column(name = "BOM_NAME", nullable = false)
	private String bomName;

	@Column(name = "IS_LAST_VERSION", nullable = false, length = 1)
	private String isLastVersion;

	@OneToMany(mappedBy = "bom", cascade = CascadeType.ALL)
	private List<BomItem> bomItemList = new ArrayList<>();
}