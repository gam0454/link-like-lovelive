package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterHasWithliveExtraAdmission {
    FILTER_HAS_WITHLIVE_EXTRA_ADMISSION_UNSPECIFIED(0),
    FILTER_HAS_WITHLIVE_EXTRA_ADMISSION_TRUE(1),
    FILTER_HAS_WITHLIVE_EXTRA_ADMISSION_FALSE(2);

    private final int value;

    FilterHasWithliveExtraAdmission(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static FilterHasWithliveExtraAdmission fromInt(int i) {
        for (FilterHasWithliveExtraAdmission type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}