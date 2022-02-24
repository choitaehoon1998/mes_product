package com.mes.produce.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MATERIAL_REQUEST")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class MaterialRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@Column(name = "FORM_DATE", length = 50)
	private Date formDate;

	@Column(name = "REQUEST_USER_INDEX_NO")
	private Long requestUserIndexNo;

	@Column(name = "TOTAL_STATUS", length = 1)
	private String totalStatus;

	@Column(name = "REQUEST_TYPE", length = 1)
	private String requestType;

	@OneToMany(mappedBy = "materialRequest", cascade = CascadeType.ALL)
	private List<MaterialRequestItem> materialRequestItemList = new ArrayList<>();
}