package com.oddno.lovelive.dto.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.SkillType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillData {

    @JsonProperty("skill_type")
    private SkillType skillType;

    @JsonProperty("card_skill_series_id")
    private int cardSkillSeriesId;

    @JsonProperty("skill_level")
    private long skillLevel;

    @JsonProperty("max_skill_level")
    private long maxSkillLevel;

}