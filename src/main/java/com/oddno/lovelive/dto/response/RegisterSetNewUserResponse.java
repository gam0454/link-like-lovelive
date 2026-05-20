package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSetNewUserResponse {

	@JsonProperty("player_id")
	private String playerId;

	@JsonProperty("device_specific_id")
	private String deviceSpecificId;

	@JsonProperty("session_token")
	private String sessionToken;
}