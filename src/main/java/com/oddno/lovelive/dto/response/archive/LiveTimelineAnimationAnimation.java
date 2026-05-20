package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class LiveTimelineAnimationAnimation {

    @JsonProperty("icon_normal_twinkle")
    private boolean iconNormalTwinkle;

    @JsonProperty("icon_strong_twinkle")
    private boolean iconStrongTwinkle;

    @JsonProperty("gift_box_falling")
    private boolean giftBoxFalling;

}