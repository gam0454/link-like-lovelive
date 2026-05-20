package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.archive.ArchiveWithliveChapter;
import com.oddno.lovelive.dto.response.archive.LiveArchiveCharacter;
import com.oddno.lovelive.dto.response.archive.LiveGiftPtRankingsGiftPtRankingsInner;
import com.oddno.lovelive.dto.response.archive.LiveTimeline;
import com.oddno.lovelive.dto.response.archive.WithliveEnquete;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetWithArchiveDataResponse {

    @JsonProperty("timelines")
    private List<LiveTimeline> timelines;

    @JsonProperty("gift_pt_rankings")
    private List<LiveGiftPtRankingsGiftPtRankingsInner> giftPtRankings;

    @JsonProperty("live_location_id")
    private int liveLocationId;

    @JsonProperty("costume_ids")
    private List<Integer> costumeIds;

    @JsonProperty("timeline_ids")
    private List<Long> timelineIds;

    @JsonProperty("archive_url")
    private String archiveUrl;

    @JsonProperty("video_url")
    private String videoUrl;

    @JsonProperty("chapters")
    private List<ArchiveWithliveChapter> chapters;

    @JsonProperty("has_extra")
    private boolean hasExtra;

    @JsonProperty("gift_star_reward_segments")
    private List<Integer> giftStarRewardSegments;

    @JsonProperty("gift_stars_threshold_for_extra_admission")
    private int giftStarsThresholdForExtraAdmission;

    @JsonProperty("has_extra_admission")
    private boolean hasExtraAdmission;

    @JsonProperty("current_play_time_second")
    private int currentPlayTimeSecond;

    @JsonProperty("total_play_time_second_without_extra")
    private int totalPlayTimeSecondWithoutExtra;

    @JsonProperty("total_play_time_second_including_extra")
    private int totalPlayTimeSecondIncludingExtra;

    @JsonProperty("unixtime_live_rec_started")
    private long unixtimeLiveRecStarted;

    @JsonProperty("live_start_time")
    private String liveStartTime;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("content_code")
    private int contentCode;

    @JsonProperty("viewer_count")
    private int viewerCount;

    @JsonProperty("user_icon_parts_info")
    private String userIconPartsInfo;

    @JsonProperty("user_gift_pt_without_archive")
    private int userGiftPtWithoutArchive;

    @JsonProperty("user_gift_pt_including_archive")
    private int userGiftPtIncludingArchive;

    @JsonProperty("user_gift_pt_ranking")
    private int userGiftPtRanking;

    @JsonProperty("total_gift_pt")
    private String totalGiftPt;

    @JsonProperty("characters")
    private List<LiveArchiveCharacter> characters;

    @JsonProperty("is_archive_published")
    private boolean isArchivePublished;

    @JsonProperty("is_horizontal")
    private boolean isHorizontal;

    @JsonProperty("enquetes")
    private List<WithliveEnquete> enquetes;

}