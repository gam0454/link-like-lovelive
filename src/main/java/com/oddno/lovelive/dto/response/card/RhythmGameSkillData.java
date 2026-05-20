package com.oddno.lovelive.dto.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.RhythmGameSkillType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RhythmGameSkillData {

    @JsonProperty("rhythm_game_skill_type")
    private RhythmGameSkillType rhythmGameSkillType;

    @JsonProperty("skill_level")
    private long skillLevel;

}