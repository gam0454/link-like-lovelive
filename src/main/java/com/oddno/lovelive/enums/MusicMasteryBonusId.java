package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MusicMasteryBonusId {
    MUSIC_MASTERY_BONUS_ID_VOLTAGE(1),
    MUSIC_MASTERY_BONUS_ID_MENTAL(2),
    MUSIC_MASTERY_BONUS_ID_HEART(3),
    MUSIC_MASTERY_BONUS_ID_LOVE(4);

    private final int value;

    MusicMasteryBonusId(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static MusicMasteryBonusId fromInt(int i) {
        for (MusicMasteryBonusId type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}