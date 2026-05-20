package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FollowLiveChatGroupListResponse {

	@JsonProperty("group_x")
	private List<String> groupX;

	@JsonProperty("group_y")
	private List<String> groupY;
}
