package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserLoginRequest {

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("device_specific_id")
    private String deviceSpecificId;

    @JsonProperty("version")
    private int version;
}