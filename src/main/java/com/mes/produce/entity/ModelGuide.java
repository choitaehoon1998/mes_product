package com.mes.produce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mes.produce.Enum.useYn.TrueFalse;
import com.mes.produce.Enum.useYn.TrueFalseConvertor;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MODEL_GUIDE")
public class ModelGuide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "MODEL_INDEX_NO")
	@JsonIgnore
	private Model model;

	@Column(name = "REVISION_NO")
	private Long revisionNo;

	@Column(name = "IS_LAST_REVISION", length = 1)
	@Convert(converter = TrueFalseConvertor.class)
	private TrueFalse isLastRevision;

	@Column(name = "GUIDE_TYPE", length = 1)
	private String guideType;

	@Column(name = "FILE_NAME", length = 500)
	private String fileName;

	@Column(name = "FILE_PATH", length = 500)
	private String filePath;
}