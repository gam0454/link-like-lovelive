package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RhythmGameSkillType {
    RHYTHM_GAME_SKILL_TYPE_CENTER_SKILL(1),
    RHYTHM_GAME_SKILL_TYPE_NORMAL_SKILL(2),
    RHYTHM_GAME_SKILL_TYPE_CENTER_ABILITY(3);

    private final int value;

    RhythmGameSkillType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static RhythmGameSkillType fromInt(int i) {
        for (RhythmGameSkillType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}