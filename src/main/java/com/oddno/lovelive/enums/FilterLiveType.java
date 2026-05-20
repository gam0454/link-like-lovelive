package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterLiveType {
    FILTER_LIVE_TYPE_UNSPECIFIED(0),
    FILTER_LIVE_TYPE_FES_LIVE(1),
    FILTER_LIVE_TYPE_WITH_MEETS(2);

    private final int value;

    FilterLiveType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static FilterLiveType fromInt(int i) {
        for (FilterLiveType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}