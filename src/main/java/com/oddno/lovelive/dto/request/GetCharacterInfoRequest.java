package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GetCharacterInfoRequest {

    @JsonProperty("character_id")
    private int characterId;

}