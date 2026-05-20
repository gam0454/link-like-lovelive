package com.oddno.lovelive.dto.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.MusicMasteryBonusId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MusicMasteryBonus {

    @JsonProperty("bonus_id")
    private MusicMasteryBonusId bonusId;

    @JsonProperty("level")
    private long level;

}