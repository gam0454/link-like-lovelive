package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryName {
    CATEGORY_NAME_COMMON(1),
    CATEGORY_NAME_SCHOOL_IDOL_STAGE(2),
    CATEGORY_NAME_SPECIAL(3),
    CATEGORY_NAME_ETC(4),
    CATEGORY_NAME_LIVE_GRAND_PRIX(5);

    private final int value;

    CategoryName(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static CategoryName fromInt(int i) {
        for (CategoryName name : values()) {
            if (name.getValue() == i) {
                return name;
            }
        }
        return null;
    }
}