package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.PlatformType;
import com.oddno.lovelive.enums.Provider;

import lombok.Getter;

@Getter
public class ConnectRequest {

    @JsonProperty("provider")
    private Provider provider;

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("id_token")
    private String idToken;

    @JsonProperty("platform_type")
    private PlatformType platformType;
}