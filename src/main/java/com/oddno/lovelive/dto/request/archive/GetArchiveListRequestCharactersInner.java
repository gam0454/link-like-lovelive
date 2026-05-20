package com.oddno.lovelive.dto.request.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.FilterCharacterAppearance;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetArchiveListRequestCharactersInner {

    @JsonProperty("character_id")
    private int characterId;

    @JsonProperty("appearance")
    private FilterCharacterAppearance appearance;

}