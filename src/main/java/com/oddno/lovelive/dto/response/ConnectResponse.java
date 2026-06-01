package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConnectResponse {

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("device_specific_id")
    private String deviceSpecificId;

    @JsonProperty("session_token")
    private String sessionToken;

    @JsonProperty("player_name")
    private String playerName;

    @JsonProperty("player_level")
    private long playerLevel;

}