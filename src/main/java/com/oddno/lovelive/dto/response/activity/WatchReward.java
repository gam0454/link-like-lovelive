package com.oddno.lovelive.dto.response.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.ItemType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchReward {

    @JsonProperty("watch_reward_type")
    private ItemType watchRewardType;

    @JsonProperty("watch_reward_id")
    private int watchRewardId;

    @JsonProperty("watch_reward_num")
    private long watchRewardNum;

}