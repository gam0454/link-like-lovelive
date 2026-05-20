package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AdvWatchableStatus {
    ADV_WATCHABLE_STATUS_ABLE(1),
    ADV_WATCHABLE_STATUS_DISABLE_LOW_LEVEL(2),
    ADV_WATCHABLE_STATUS_DISABLE_LAST_PART(3),
    ADV_WATCHABLE_STATUS_UNDISCLOSED(4),
    ADV_WATCHABLE_STATUS_FINISHED(5),
    ADV_WATCHABLE_STATUS_LOCKED(6),
    ADV_WATCHABLE_STATUS_TARGET_PART_LOCKED(7);

    private final int value;

    AdvWatchableStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static AdvWatchableStatus fromInt(int i) {
        for (AdvWatchableStatus type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}