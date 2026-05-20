package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WithliveEnqueteOption {

    @JsonProperty("option_id")
    private String optionId;

    @JsonProperty("option_letter")
    private String optionLetter;

    @JsonProperty("text")
    private String text;

    @JsonProperty("rate")
    private Integer rate;

    @JsonProperty("is_correct")
    private Boolean isCorrect;

    @JsonProperty("is_max_rate")
    private boolean isMaxRate;

}