package com.oddno.lovelive.dto.response.archive;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveTicketRank;
import com.oddno.lovelive.enums.LiveType;
import com.oddno.lovelive.enums.WithstationStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiveInfoMusicvideo {

    @JsonProperty("live_type")
    private LiveType liveType;

    @JsonProperty("live_id")
    private String liveId;

    @JsonProperty("status")
    private WithstationStatus status;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("ticket_list")
    private List<TicketInfo> ticketList;

    @JsonProperty("trailer_start_time")
    private LocalDateTime trailerStartTime;

    @JsonProperty("trailer_end_time")
    private LocalDateTime trailerEndTime;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("interaction_start_time")
    private LocalDateTime interactionStartTime;

    @JsonProperty("interaction_end_time")
    private LocalDateTime interactionEndTime;

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

}