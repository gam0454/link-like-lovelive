package com.oddno.lovelive.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveTicketRank {
	TICKET_RANK_NULL(0),
    TICKET_RANK_GUEST(1),
    TICKET_RANK_D(2),
    TICKET_RANK_C(3),
    TICKET_RANK_B(4),
    TICKET_RANK_A(5),
    TICKET_RANK_S(6),
    TICKET_RANK_E(7);

    private final int value;

    LiveTicketRank(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static LiveTicketRank fromInt(int i) {
        for (LiveTicketRank type : values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        return null;
    }
}