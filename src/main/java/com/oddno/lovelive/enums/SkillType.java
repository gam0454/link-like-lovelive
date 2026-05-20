package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SkillType {
	SKILL_TYPE_SPECIAL_APPEAL(1),
	SKILL_TYPE_SKILL(2),
	SKILL_TYPE_ABILITY(3);

	private final int value;

	SkillType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

    @JsonValue
	public static SkillType fromInt(int i) {
		for (SkillType type : values()) {
			if (type.getValue() == i) {
				return type;
			}
		}
		return null;
	}
}
