package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.archive.ArchiveFesliveChapter;
import com.oddno.lovelive.dto.response.archive.GetFesArchiveDataResponseAllOfEnquetes;
import com.oddno.lovelive.dto.response.archive.LiveArchiveCharacter;
import com.oddno.lovelive.dto.response.archive.LiveGiftPtRankingsGiftPtRankingsInner;
import com.oddno.lovelive.dto.response.archive.LiveTimeline;
import com.oddno.lovelive.enums.LiveCameraType;
import com.oddno.lovelive.enums.LiveTicketRank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetFesArchiveDataResponse {

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
    private List<ArchiveFesliveChapter> chapters;

    @JsonProperty("has_extra_admission")
    private boolean hasExtraAdmission;

    @JsonProperty("current_play_time_second")
    private int currentPlayTimeSecond;

    @JsonProperty("total_play_time_second")
    private int totalPlayTimeSecond;

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

    @JsonProperty("user_gift_pt")
    private int userGiftPt;

    @JsonProperty("user_gift_pt_ranking")
    private int userGiftPtRanking;

    @JsonProperty("total_gift_pt")
    private String totalGiftPt;

    @JsonProperty("characters")
    private List<LiveArchiveCharacter> characters;

    @JsonProperty("enquetes")
    private List<GetFesArchiveDataResponseAllOfEnquetes> enquetes;

    @JsonProperty("camera_focus_character_id")
    private int cameraFocusCharacterId;

    @JsonProperty("selectable_camera_types")
    private List<LiveCameraType> selectableCameraTypes;

    @JsonProperty("current_camera_type")
    private LiveCameraType currentCameraType;

    @JsonProperty("ticket_rank")
    private LiveTicketRank ticketRank;

}