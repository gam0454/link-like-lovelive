package com.oddno.lovelive.dto.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import java.util.List;

@Getter
@Setter
@Builder
public class CharacterBonus {

    @JsonProperty("character_id")
    private int characterId;

    @JsonProperty("music_mastery_bonus")
    private long musicMasteryBonus;

    @JsonProperty("love_correction_value")
    private long loveCorrectionValue;

    @JsonProperty("music_mastery_bonus_list")
    private List<MusicMasteryBonus> musicMasteryBonusList;

    @JsonProperty("season_fan_level")
    private long seasonFanLevel;

}