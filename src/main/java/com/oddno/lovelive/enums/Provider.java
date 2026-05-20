package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Provider {
    PROVIDER_AUTHCODE(1),
    PROVIDER_GOOGLE(2),
    PROVIDER_APPLE(3),
    PROVIDER_TWITTER(4);

    private final int value;

    Provider(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static Provider fromInt(int i) {
        for (Provider type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}