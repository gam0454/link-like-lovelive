package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WithstationStatus {
    TRAILER(0),
    WATCHABLE(1);

    private final int value;

    WithstationStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static WithstationStatus fromInt(int i) {
        for (WithstationStatus type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}