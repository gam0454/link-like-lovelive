package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WithliveEnqueteStatus {
	WITHLIVE_ENQUETE_STATUS_WAITING(0),
    WITHLIVE_ENQUETE_STATUS_IN_PROGRESS(1),
    WITHLIVE_ENQUETE_STATUS_END(2),
    WITHLIVE_ENQUETE_STATUS_RESULT_READY(3),
    WITHLIVE_ENQUETE_STATUS_RESULT_OPEN(4);

	private final int value;

	WithliveEnqueteStatus(int value) {
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	@JsonCreator
	public static WithliveEnqueteStatus fromInt(int i) {
		for (WithliveEnqueteStatus type : values()) {
			if (type.getValue() == i) {
				return type;
			}
		}
		return null;
	}
}