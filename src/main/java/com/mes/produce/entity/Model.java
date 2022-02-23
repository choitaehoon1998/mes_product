package com.mes.produce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MODEL")
@Getter
@Setter
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_NO", nullable = false)
	private Long indexNo;

	@Column(name = "MODEL_NAME")
	private String modelName;

	@OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
	List<ModelGuide> modelGuideList = new ArrayList<>();
}