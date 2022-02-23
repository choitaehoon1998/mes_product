package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "PROCESS_GROUP_STEP")
public class ProcessGroupStep {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "PROCESS_GROUP_INDEX_NO")
	private ProcessGroup processGroupIndexNo;

	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "INSP_YN", length = 1)
	private String inspYn;

	@Column(name = "END_CUST_CD")
	private Integer endCustCd;

	@Column(name = "PO_PRICE")
	private Integer poPrice;

	@Column(name = "PL_PRICE")
	private Integer plPrice;

	@Column(name = "REMARK", length = 2000)
	private String remark;

	@Column(name = "PRO_CHECK", length = 1)
	private String proCheck;
}