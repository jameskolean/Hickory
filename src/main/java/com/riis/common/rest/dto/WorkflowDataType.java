package com.riis.common.rest.dto;

import java.util.Date;

import org.joda.time.LocalDate;

import com.google.common.base.Strings;

public enum WorkflowDataType {

	BOOLEAN, // Yes/No, True/False, checkbox/toggle/etc.
	DATE, // date only, no time.
	LABEL, // ???
	MULTILINE_TEXT, // 1 or more lines of text
	MULTISELECT, // select 1 or more of N options
	OPTION, // an option to be selected
	SELECT, // select exactly 1 of N options
	TEXT; // single line of text

	public Boolean deserializeBoolean(final String value) {
		if (!Strings.isNullOrEmpty(value)) {
			final String cleanValue = value.trim().toLowerCase();
			switch (this) {
			case BOOLEAN:
				return "yes".equals(cleanValue) || "y".equals(cleanValue) || "true".equals(cleanValue)
						|| "t".equals(cleanValue);
			default:
				break;
			}
		}
		return null;

	}

	public LocalDate deserializeDate(final String value) {
		if (!Strings.isNullOrEmpty(value)) {
			switch (this) {
			case DATE:
				return LocalDate.parse(value);
			default:
				break;
			}
		}
		return null;

	}

	public String serialize(final boolean value) {
		return value ? "true" : "false";
	}

	public String serialize(final Object value) {
		switch (this) {
		case BOOLEAN:
			if (value instanceof Boolean) {
				return ((Boolean) value).toString();
			}
		case DATE:
			if (value instanceof LocalDate) {
				return ((LocalDate) value).toString();
			} else if (value instanceof Date) {
				return new LocalDate(value).toString();
			} else {
				return null;
			}
		case LABEL:
			return value.toString();
		case MULTILINE_TEXT:
			return value.toString();
		case TEXT:
			return value.toString();
		default:
			return null;
		}

	}

}
