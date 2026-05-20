package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class FilterableCharacter {

    @JsonProperty("character_id")
    private int characterId;

    @JsonProperty("label")
    private String label;

}