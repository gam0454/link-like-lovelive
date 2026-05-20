package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveType {
    LIVE_TYPE_FES_LIVE(1),
    LIVE_TYPE_WITH_MEETS(2),
    LIVE_TYPE_WITH_STATION(3),
    LIVE_TYPE_MUSIC_VIDEO(4);

    private final int value;

    LiveType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static LiveType fromInt(int i) {
        for (LiveType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}