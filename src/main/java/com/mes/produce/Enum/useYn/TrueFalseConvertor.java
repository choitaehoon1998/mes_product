package com.mes.produce.Enum.useYn;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class TrueFalseConvertor implements AttributeConverter<TrueFalse, String> {
	@Override
	public String convertToDatabaseColumn(TrueFalse attribute) {
		return attribute.getCode();
	}

	@Override
	public TrueFalse convertToEntityAttribute(String dbData) {
		return EnumSet.allOf(TrueFalse.class).stream()
				.filter(e -> e.getCode().equals(dbData))
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}
}
