package com.oddno.lovelive.dto.response.archive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.archive.ArchiveCharacter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiveInfoCharacterListInner {

	@JsonProperty("character_id")
	private int characterId;

	public static List<LiveInfoCharacterListInner> fromDtos(List<ArchiveCharacter> characters) {
		return characters.stream()
				.map(character -> LiveInfoCharacterListInner.builder().characterId(character.getCharacterId()).build())
				.toList();
	}
}