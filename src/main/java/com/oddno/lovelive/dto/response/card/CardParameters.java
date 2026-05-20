package com.oddno.lovelive.dto.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class CardParameters {

    @JsonProperty("smile")
    private long smile;

    @JsonProperty("pure")
    private long pure;

    @JsonProperty("cool")
    private long cool;

    @JsonProperty("mental")
    private long mental;

    @JsonProperty("beat_point")
    private long beatPoint;

}