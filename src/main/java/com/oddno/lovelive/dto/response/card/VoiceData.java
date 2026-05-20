package com.oddno.lovelive.dto.response.card;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.card.StyleVoicesRecord;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VoiceData {

	@JsonProperty("voices_id")
	private int voicesId;

	@JsonProperty("priority")
	private long priority;

	@JsonProperty("is_opened")
	private boolean isOpened;

	public static List<VoiceData> toRows(List<StyleVoicesRecord> voices) {
		if (voices == null) {
			return null;
		}

		return voices.stream().map(voice -> {
			return VoiceData.builder().voicesId(voice.getId()).priority(voice.getPriority()).isOpened(true).build();
		}).collect(Collectors.toList());
	}
}