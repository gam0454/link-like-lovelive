package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterHasWithliveExtra {
    FILTER_HAS_WITHLIVE_EXTRA_UNSPECIFIED(0),
    FILTER_HAS_WITHLIVE_EXTRA_TRUE(1),
    FILTER_HAS_WITHLIVE_EXTRA_FALSE(2);

    private final int value;

    FilterHasWithliveExtra(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static FilterHasWithliveExtra fromInt(int i) {
        for (FilterHasWithliveExtra type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}