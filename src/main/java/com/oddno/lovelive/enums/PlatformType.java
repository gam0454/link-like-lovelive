package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PlatformType {
    PLATFORM_TYPE_GOOGLE(1),
    PLATFORM_TYPE_APPLE(2);

    private final int value;

    PlatformType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static PlatformType fromInt(int i) {
        for (PlatformType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}