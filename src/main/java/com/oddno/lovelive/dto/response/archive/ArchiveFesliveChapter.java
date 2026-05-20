package com.oddno.lovelive.dto.response.archive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.archive.ArchiveChapter;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class ArchiveFesliveChapter {

	@JsonProperty("name")
	private String name;

	@JsonProperty("play_time_second")
	private int playTimeSecond;

	@JsonProperty("is_extra")
	private boolean isExtra;

	@JsonProperty("is_available")
	private boolean isAvailable;

	public static List<ArchiveFesliveChapter> fromDtos(List<ArchiveChapter> chapters) {
		return chapters.stream()
				.map(chapter -> ArchiveFesliveChapter.builder()
						.name(chapter.getName())
						.playTimeSecond(chapter.getPlayTimeSecond())
						.isExtra(chapter.isExtra())
						.isAvailable(chapter.isAvailable())
						.build())
				.toList();
	}

}