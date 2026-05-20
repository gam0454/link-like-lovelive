package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CardGetListRequest {

    @JsonProperty("search_conditions")
    private String searchConditions;

}