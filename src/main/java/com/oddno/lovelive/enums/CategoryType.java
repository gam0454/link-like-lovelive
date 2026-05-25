package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryType {
    CATEGORY_TYPE_UNDEFINED(0),
    CATEGORY_TYPE_LOGIN(1),
    CATEGORY_TYPE_CARD(2),
    CATEGORY_TYPE_LIVE(3),
    CATEGORY_TYPE_ACTIVITY(4);

    private final int value;

    CategoryType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static CategoryType fromInt(int i) {
        for (CategoryType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}