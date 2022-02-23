package com.mes.produce.Enum.useYn;

import com.mes.produce.Enum.CodeValue;

public enum UseYn implements CodeValue {
	Y("Y", "사용함"),
	N("N", "사용안함");

	private String code;
	private String value;

	UseYn(String code, String value) {
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
