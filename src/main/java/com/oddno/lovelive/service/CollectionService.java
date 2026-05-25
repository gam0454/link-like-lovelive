package com.oddno.lovelive.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.GetCharacterInfoRequest;
import com.oddno.lovelive.dto.response.GetCharacterInfoResponse;
import com.oddno.lovelive.dto.response.GetGallaryListResponse;
import com.oddno.lovelive.dto.response.card.CardInfo;
import com.oddno.lovelive.dto.response.card.CollectionCharacterInfo;
import com.oddno.lovelive.dto.response.comics.GetGallaryListResponseGallaryInfoListInner;
import com.oddno.lovelive.gamedata.card.CardDatasRecord;
import com.oddno.lovelive.gamedata.card.CardFactory;
import com.oddno.lovelive.gamedata.card.CharactersRecord;
import com.oddno.lovelive.gamedata.comics.ComicsFactory;
import com.oddno.lovelive.gamedata.comics.ComicsRecord;

@Service
public class CollectionService {

	public GetGallaryListResponse getGallaryList() {
		Map<Integer, ComicsRecord> comics = ComicsFactory.getComics();
		return GetGallaryListResponse.builder()
				.gallaryInfoList(comics.values()
						.stream()
						.map(comic -> GetGallaryListResponseGallaryInfoListInner.builder()
								.comicsId(comic.getId())
								.name(comic.getName())
								.build())
						.toList())
				.build();
	}

	public GetCharacterInfoResponse getCharacterInfo(GetCharacterInfoRequest request) {
		CharactersRecord character = CardFactory.getCharacter(request.getCharacterId());
		return GetCharacterInfoResponse.builder()
				.collectionCharacterInfo(CollectionCharacterInfo.builder()
						.characterId(character.getId())
						.nameLast(character.getNameLast())
						.nameFirst(character.getNameFirst())
						.latinAlphabetNameLast(character.getLatinAlphabetNameLast())
						.latinAlphabetNameFirst(character.getLatinAlphabetNameFirst())
						.characterVoice(character.getCharacterVoice())
						.themeColor(character.getThemeColor())
						.cardList(CardInfo.toRows(CardFactory.getCardDatas()
								.values()
								.stream()
								.filter(o -> o.getCharactersId() == character.getId())
								.map(CardDatasRecord::getCenterSkillSeriesId)
								.distinct()
								.toList()))
						.build())
				.build();
	}
}
