package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveTimelineType {
	LIVE_TIMELINE_TYPE_COMMENT("comment", 1),
	LIVE_TIMELINE_TYPE_GIFT("gift", 2),
	LIVE_TIMELINE_TYPE_MESSAGE_CARD("message_card", 3);

    private final String stringValue;
    private final int intValue;

    LiveTimelineType(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    @JsonValue
    public String getStringValue() {
        return stringValue;
    }

    @JsonCreator
    public static LiveTimelineType fromValue(Object value) {
        if (value instanceof String s) {
            for (LiveTimelineType type : values()) {
                if (type.stringValue.equalsIgnoreCase(s)) return type;
            }
        } else if (value instanceof Integer i) {
            for (LiveTimelineType type : values()) {
                if (type.intValue == i) return type;
            }
        }
        return null;
    }
}