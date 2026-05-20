package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.card.UserCardData;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardGetListResponse {

	@JsonProperty("user_card_data_list")
	private List<UserCardData> userCardDataList;

}