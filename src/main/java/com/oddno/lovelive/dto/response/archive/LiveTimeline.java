package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveTimelineSenderType;
import com.oddno.lovelive.enums.LiveTimelineType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiveTimeline {

    @JsonProperty("timeline_id")
    private String timelineId;

    @JsonProperty("name_color")
    private String nameColor;

    @JsonProperty("background_color")
    private String backgroundColor;

    @JsonProperty("text_color")
    private String textColor;

    @JsonProperty("animation")
    private LiveTimelineAnimationAnimation animation;

    @JsonProperty("type")
    private LiveTimelineType type;

    @JsonProperty("sender_type")
    private LiveTimelineSenderType senderType;

    @JsonProperty("user_player_id")
    private String userPlayerId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("submit_time")
    private String submitTime;

    @JsonProperty("body")
    private String body;

    @JsonProperty("text_size")
    private int textSize;

    @JsonProperty("is_text_bold")
    private boolean isTextBold;

    @JsonProperty("item_id")
    private int itemId;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("gift_pt")
    private int giftPt;

    @JsonProperty("user_icon_parts_info")
    private String userIconPartsInfo;

    @JsonProperty("display_user_icon")
    private boolean displayUserIcon;

    @JsonProperty("asset_icon_parts_info")
    private String assetIconPartsInfo;

    @JsonProperty("image_size")
    private int imageSize;

    @JsonProperty("play_time_second")
    private int playTimeSecond;

}