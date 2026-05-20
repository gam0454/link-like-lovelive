package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveCameraType {
	LIVE_CAMERA_TYPE_UNDEFINED(0),
	LIVE_CAMERA_TYPE_DYNAMIC_VIEW(1),
	LIVE_CAMERA_TYPE_ARENA_VIEW(2),
	LIVE_CAMERA_TYPE_STAND_VIEW(3),
	LIVE_CAMERA_TYPE_SCHOOL_IDLE(4);

	private final int value;

	LiveCameraType(int value) {
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	@JsonCreator
	public static LiveCameraType fromInt(int i) {
		for (LiveCameraType type : values()) {
			if (type.getValue() == i) {
				return type;
			}
		}
		return null;
	}
}