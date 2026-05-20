package com.oddno.lovelive.dto.response.archive;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveTicketRank;
import com.oddno.lovelive.enums.LiveType;
import com.oddno.lovelive.gamedata.archive.Archive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiveInfo {

	@JsonProperty("archives_id")
	private String archivesId;

	@JsonProperty("live_type")
	private LiveType liveType;

	@JsonProperty("live_id")
	private String liveId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("ticket_list")
	private List<TicketInfo> ticketList;

	@JsonProperty("trailer_start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime trailerStartTime;

	@JsonProperty("trailer_end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime trailerEndTime;

	@JsonProperty("live_start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime liveStartTime;

	@JsonProperty("live_end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime liveEndTime;

	@JsonProperty("start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime startTime;

	@JsonProperty("end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime endTime;

	@JsonProperty("open_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime openTime;

	@JsonProperty("close_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private LocalDateTime closeTime;

	@JsonProperty("external_link")
	private String externalLink;

	@JsonProperty("thumbnail_image_url")
	private String thumbnailImageUrl;

	@JsonProperty("ticket_rank")
	private LiveTicketRank ticketRank;

	@JsonProperty("character_list")
	private List<LiveInfoCharacterListInner> characterList;

	@JsonProperty("total_playing_time_second")
	private int totalPlayingTimeSecond;

	@JsonProperty("is_publish_video_url")
	private boolean isPublishVideoUrl;

	@JsonProperty("is_extra_started")
	private boolean isExtraStarted;

	@JsonProperty("has_extra")
	private boolean hasExtra;

	@JsonProperty("has_extra_admission")
	private boolean hasExtraAdmission;

	@JsonProperty("earned_star_count")
	private int earnedStarCount;

	@JsonProperty("gift_stars_threshold_for_extra_admission")
	private int giftStarsThresholdForExtraAdmission;

	@JsonProperty("video_url")
	private String videoUrl;

	@JsonProperty("archive_video_size_in_byte")
	private long archiveVideoSizeInByte;

	@JsonProperty("is_scheduled_start_time_visible")
	private boolean isScheduledStartTimeVisible;

	public static LiveInfo fromDto(Archive archive) {
		return LiveInfo.builder()
				.archivesId(archive.getArchivesId())
				.liveType(archive.getLiveType())
				.liveId(archive.getLiveId())
				.name(archive.getName())
				.description(archive.getDescription())
				.ticketList(archive.getTicketList())
				.trailerStartTime(archive.getTrailerStartTime())
				.trailerEndTime(archive.getTrailerEndTime())
				.liveStartTime(archive.getLiveStartTime())
				.liveEndTime(archive.getLiveEndTime())
				.startTime(archive.getStartTime())
				.endTime(archive.getEndTime())
				.openTime(archive.getOpenTime())
				.closeTime(archive.getCloseTime())
				.externalLink(archive.getExternalLink())
				.thumbnailImageUrl(archive.getThumbnailImageUrl())
				.ticketRank(archive.getTicketRank())
				.characterList(LiveInfoCharacterListInner.fromDtos(archive.getCharacterList()))
				.totalPlayingTimeSecond(archive.getTotalPlayingTimeSecond())
				.isPublishVideoUrl(archive.isPublishVideoUrl())
				.isExtraStarted(archive.isExtraStarted())
				.hasExtra(archive.isHasExtra())
				.hasExtraAdmission(archive.isHasExtraAdmission())
				.earnedStarCount(archive.getEarnedStarCount())
				.giftStarsThresholdForExtraAdmission(archive.getGiftStarsThresholdForExtraAdmission())
				.videoUrl(archive.getVideoUrl())
				.archiveVideoSizeInByte(archive.getArchiveVideoSizeInByte())
				.isScheduledStartTimeVisible(archive.isScheduledStartTimeVisible())
				.build();
	}

}