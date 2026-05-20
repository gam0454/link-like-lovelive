package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveTimelineSenderType {
	LIVE_TIMELINE_SENDER_TYPE_PLAYER("player", 1),
	LIVE_TIMELINE_SENDER_TYPE_CHARACTER("character", 2),
	LIVE_TIMELINE_SENDER_TYPE_SYSTEM("system", 3);

    private final String stringValue;
    private final int intValue;

    LiveTimelineSenderType(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    @JsonValue
    public String getStringValue() {
        return stringValue;
    }

    @JsonCreator
    public static LiveTimelineSenderType fromValue(Object value) {
        if (value instanceof String s) {
            for (LiveTimelineSenderType type : values()) {
                if (type.stringValue.equalsIgnoreCase(s)) return type;
            }
        } else if (value instanceof Integer i) {
            for (LiveTimelineSenderType type : values()) {
                if (type.intValue == i) return type;
            }
        }
        return null;
    }
}