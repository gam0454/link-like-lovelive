package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.ApproveTermsType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterApproveTermsResponse {

	@JsonProperty("type")
	private ApproveTermsType type;

	@JsonProperty("player_id")
	private String playerId;

	@JsonProperty("device_specific_id")
	private String deviceSpecificId;

	@JsonProperty("session_token")
	private String sessionToken;

}