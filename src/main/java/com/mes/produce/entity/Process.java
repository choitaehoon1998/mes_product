package com.mes.produce.entity;

import com.mes.produce.Enum.useYn.TrueFalse;
import com.mes.produce.Enum.useYn.TrueFalseConvertor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROCESS")
public class Process {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@Column(name = "PROCESS_NAME")
	private String processName;

	@Column(name = "PROCESS_NO")
	private Long processNo;

	@Column(name = "OUTSOURCING_TYPE")
	private String outsourcingType;

	@Column(name = "USE_YN")
	@Convert(converter = TrueFalseConvertor.class)
	private TrueFalse trueFalse;

	@Column(name = "CUST_CD")
	private String custCd;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "PROCESS_TYPE")
	private String processType;
}
