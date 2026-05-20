package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemType {
    ITEM_TYPE_UNDEFINED(0),
    ITEM_TYPE_ITEM(1),
    ITEM_TYPE_CARD(2),
    ITEM_TYPE_APP_RESOURCE(3),
    ITEM_TYPE_LIMIT_BREAK(4),
    ITEM_TYPE_MUSIC(5),
    ITEM_TYPE_STICKER(6),
    ITEM_TYPE_EMOJI(7),
    ITEM_TYPE_GRADE_PT(8),
    ITEM_TYPE_MESSAGE_CARD(9);

    private final int value;

    ItemType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static ItemType fromInt(int i) {
        for (ItemType type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}