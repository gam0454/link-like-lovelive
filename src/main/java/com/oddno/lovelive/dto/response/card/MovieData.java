package com.oddno.lovelive.dto.response.card;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.card.StyleMoviesRecord;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieData {

	@JsonProperty("movies_id")
	private int moviesId;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("is_opened")
	private boolean isOpened;

	public static List<MovieData> toRows(List<StyleMoviesRecord> movies) {
		if (movies == null) {
			return null;
		}

		return movies.stream().map(movie -> {
			return MovieData.builder().moviesId(movie.getId()).priority(1).isOpened(true).build();
		}).collect(Collectors.toList());
	}
}