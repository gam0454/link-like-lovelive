package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApproveTermsType {
	APPROVE_TERMS_TYPE_APPROVAL_UPDATE(1),
    APPROVE_TERMS_TYPE_CERTIFICATION_REGISTRATION(2);

    private final int value;

    ApproveTermsType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static ApproveTermsType fromInt(int i) {
        for (ApproveTermsType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}