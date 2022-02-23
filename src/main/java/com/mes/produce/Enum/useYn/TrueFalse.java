package com.mes.produce.Enum.useYn;

import com.mes.produce.Enum.CodeValue;

public enum TrueFalse implements CodeValue {
	Y("Y", "사실"),
	N("N", "거짓");

	private String code;
	private String value;

	TrueFalse(String code, String value) {
		this.code = code;
		this.value = value;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getValue() {
		return value;
	}
}
