package com.oddno.lovelive.dto.response.archive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.archive.ArchiveCharacter;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class LiveArchiveCharacter {

	@JsonProperty("character_id")
	private int characterId;

	@JsonProperty("is_guest")
	private boolean isGuest;

	public static List<LiveArchiveCharacter> fromDtos(List<ArchiveCharacter> characters) {
		return characters.stream()
				.map(character -> LiveArchiveCharacter.builder()
						.characterId(character.getCharacterId())
						.isGuest(character.isGuest())
						.build())
				.toList();
	}
}