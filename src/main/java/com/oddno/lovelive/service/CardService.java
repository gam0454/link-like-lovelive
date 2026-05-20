package com.oddno.lovelive.service;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.CardGetListRequest;
import com.oddno.lovelive.dto.response.CardGetListResponse;
import com.oddno.lovelive.dto.response.card.UserCardData;
import com.oddno.lovelive.gamedata.card.CardFactory;

@Service
public class CardService {

	public CardGetListResponse getList(CardGetListRequest request) {
		return CardGetListResponse.builder().userCardDataList(UserCardData.toRows(CardFactory.getCardDatas())).build();
	}
}
