package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.card.CollectionCharacterInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetCharacterInfoResponse {

    @JsonProperty("collection_character_info")
    private CollectionCharacterInfo collectionCharacterInfo;

}