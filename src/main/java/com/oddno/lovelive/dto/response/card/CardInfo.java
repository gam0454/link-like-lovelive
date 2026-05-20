package com.oddno.lovelive.dto.response.card;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.card.CardFactory;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardInfo {

	@JsonProperty("card_datas_id")
	private int cardDatasId;

	@JsonProperty("voice_list")
	private List<VoiceData> voiceList;

	@JsonProperty("movie_list")
	private List<MovieData> movieList;

	public static List<CardInfo> toRows(List<Integer> values) {
		if (values == null) {
			return null;
		}

		return values.stream().map(value -> {
			return CardInfo.builder()
					.cardDatasId(value)
					.voiceList(VoiceData.toRows(CardFactory.getStyleVoice(value / 10)))
					.movieList(MovieData.toRows(CardFactory.getStyleMovie(value / 10)))
					.build();
		}).collect(Collectors.toList());
	}
}