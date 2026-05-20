package com.oddno.lovelive.gamedata.adv;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class AdvDatasRecord {

	private int id;
	private int advSeriesId;
	private String name;
	private String description;
	private int scriptId;
	private int openSeasonFanLevel;
	private String rewardType;
	private List<Integer> watchRewardId;
	private List<Integer> watchRewardNum;
	private List<Integer> rewardTextId;
	private int orderId;
	private String subTitleName;
	private OffsetDateTime startTime;
	private OffsetDateTime endTime;
	private int isPeriod;
	private int advScreenMode;
	private int advUnlockItemId;
	private int advUnlockItemNum;
	private int advUnlockConditionValue;
	private int isPersistentReward;
}
