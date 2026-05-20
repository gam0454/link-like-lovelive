package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
    USER_TYPE_TEMPORARY(0),
    USER_TYPE_GUEST(1),
    USER_TYPE_REGISTERD(2),
    USER_TYPE_BANNED(3),
    USER_TYPE_DELETE(9);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static UserType fromInt(int i) {
        for (UserType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}