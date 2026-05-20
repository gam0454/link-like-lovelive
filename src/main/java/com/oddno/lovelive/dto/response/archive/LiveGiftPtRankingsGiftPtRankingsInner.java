package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class LiveGiftPtRankingsGiftPtRankingsInner {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_icon_parts_info")
    private String userIconPartsInfo;

    @JsonProperty("ranking")
    private int ranking;

    @JsonProperty("gift_pt")
    private int giftPt;

}