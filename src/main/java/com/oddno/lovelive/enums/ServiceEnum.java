package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceEnum {
    USER_PUSH_DEVICE_SERVICE_AP_NS(1),
    USER_PUSH_DEVICE_SERVICE_FCM(2),
    USER_PUSH_DEVICE_SERVICE_WEB_PUSH(4),
    USER_PUSH_DEVICE_SERVICE_ADM(5);

    private final int value;

    ServiceEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static ServiceEnum fromInt(int i) {
        for (ServiceEnum type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}