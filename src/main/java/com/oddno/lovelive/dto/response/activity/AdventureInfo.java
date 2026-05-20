package com.oddno.lovelive.dto.response.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.AdvWatchableStatus;
import com.oddno.lovelive.gamedata.adv.AdvDatasRecord;

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
public class AdventureInfo {

    @JsonProperty("adv_data_id")
    private int advDataId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("order_id")
    private long orderId;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("description")
    private String description;

    @JsonProperty("watchable_status")
    private AdvWatchableStatus watchableStatus;

    @JsonProperty("is_not_watched")
    private boolean isNotWatched;

    @JsonProperty("open_season_fan_level")
    private long openSeasonFanLevel;

    @JsonProperty("watch_reward_list")
    private List<WatchReward> watchRewardList;

    @JsonProperty("adv_unlock_item_num")
    private long advUnlockItemNum;

	public static List<AdventureInfo> toRows(Map<Integer, AdvDatasRecord> advs) {
		if (advs == null) {
			return null;
		}

		return advs.values().stream().map(adv -> {
			return AdventureInfo.builder()
					.advDataId(adv.getId())
					.title(adv.getName())
					.orderId(adv.getOrderId())
					.subtitle(adv.getSubTitleName())
					.description(adv.getDescription())
					.watchableStatus(AdvWatchableStatus.ADV_WATCHABLE_STATUS_ABLE)
					.isNotWatched(true)
					.openSeasonFanLevel(adv.getOpenSeasonFanLevel())
					.watchRewardList(new ArrayList<>())
					.advUnlockItemNum(adv.getAdvUnlockItemNum())
					.build();
		}).collect(Collectors.toList());
	}

}