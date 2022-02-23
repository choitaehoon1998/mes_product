package com.mes.produce.dto.responseDto;

import com.mes.produce.entity.ProcessGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProcessGroupResponseDto {
	private Long indexNo;
	private String processGroupCd;
	private Integer revisionNo;
	private String lastRevision;
	private String groupName;
	private String custCd;
	private String useYn;
	private String groupType;
	private List<ProcessGroupStepResponseDto> processGroupStepList;

	@Builder
	public ProcessGroupResponseDto(ProcessGroup processGroup) {
		indexNo = processGroup.getIndexNo();
		processGroupCd = processGroup.getProcessGroupCd();
		revisionNo = processGroup.getRevisionNo();
		lastRevision = processGroup.getLastRevision();
		groupName = processGroup.getGroupName();
		custCd = processGroup.getCustCd();
		useYn = processGroup.getUseYn().getCode();
		groupType = processGroup.getGroupType();
		List<ProcessGroupStepResponseDto> pgsList = new ArrayList<>();
		processGroup.getProcessGroupStepList().forEach(e -> {
			pgsList.add(new ProcessGroupStepResponseDto(e));
		});
		processGroupStepList = pgsList;
	}
}
