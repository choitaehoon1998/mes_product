package com.mes.produce.dto.responseDto;

import com.mes.produce.entity.ProcessGroupStep;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessGroupStepResponseDto {
	private Long indexNo;
	private Integer seq;
	private String inspYn;
	private Integer endCustCd;
	private Integer poPrice;
	private Integer plPrice;
	private String remark;
	private String proCheck;

	@Builder
	public ProcessGroupStepResponseDto(ProcessGroupStep processGroupStep) {
		indexNo = processGroupStep.getIndexNo();
		seq = processGroupStep.getSeq();
		inspYn = processGroupStep.getInspYn();
		endCustCd = processGroupStep.getEndCustCd();
		poPrice = processGroupStep.getPoPrice();
		plPrice = processGroupStep.getPlPrice();
		remark = processGroupStep.getRemark();
		proCheck = processGroupStep.getProCheck();
	}
}
