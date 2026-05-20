package com.oddno.lovelive.dto.response.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CollectionCharacterInfo {

    @JsonProperty("character_id")
    private int characterId;

    @JsonProperty("name_last")
    private String nameLast;

    @JsonProperty("name_first")
    private String nameFirst;

    @JsonProperty("latin_alphabet_name_last")
    private String latinAlphabetNameLast;

    @JsonProperty("latin_alphabet_name_first")
    private String latinAlphabetNameFirst;

    @JsonProperty("character_voice")
    private String characterVoice;

    @JsonProperty("theme_color")
    private String themeColor;

    @JsonProperty("card_list")
    private List<CardInfo> cardList;

}