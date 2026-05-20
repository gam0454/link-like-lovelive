package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterCharacterAppearance {
    FILTER_CHARACTER_APPEARANCE_UNSPECIFIED(0),
    FILTER_CHARACTER_APPEARANCE_TRUE(1),
    FILTER_CHARACTER_APPEARANCE_FALSE(2);

    private final int value;

    FilterCharacterAppearance(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static FilterCharacterAppearance fromInt(int i) {
        for (FilterCharacterAppearance type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}