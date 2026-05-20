package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterGetTermsResponse {

	@JsonProperty("terms")
	private String terms;

}