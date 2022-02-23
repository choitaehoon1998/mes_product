package com.mes.produce.entity;

import com.mes.produce.Enum.useYn.UseYn;
import com.mes.produce.Enum.useYn.UseYnConvertor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PROCESS_GROUP", uniqueConstraints = @UniqueConstraint(columnNames = {"PROCESS_GROUP_CD", "REVISION_NO"}))
public class ProcessGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@OneToMany(mappedBy = "processGroupIndexNo", cascade = CascadeType.ALL)
	List<ProcessGroupStep> processGroupStepList = new ArrayList<>();

	@Column(name = "PROCESS_GROUP_CD")
	private String processGroupCd;

	@Column(name = "REVISION_NO")
	private Integer revisionNo;

	@Column(name = "LAST_REVISION", length = 1)
	private String lastRevision;

	@Column(name = "GROUP_NAME")
	private String groupName;

	@Column(name = "CUST_CD")
	private String custCd;

	@Column(name = "USE_YN", length = 1)
	@Convert(converter = UseYnConvertor.class)
	private UseYn useYn;

	@Column(name = "GROUP_TYPE", length = 1)
	private String groupType;
}