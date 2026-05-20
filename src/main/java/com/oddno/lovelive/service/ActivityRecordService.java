package com.oddno.lovelive.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.PlayAdvDataRequest;
import com.oddno.lovelive.dto.response.GetTopResponse;
import com.oddno.lovelive.dto.response.PlayAdvDataResponse;
import com.oddno.lovelive.dto.response.activity.ActivityRecordMonthlyInfo;
import com.oddno.lovelive.gamedata.adv.AdvFactory;

@Service
public class ActivityRecordService {

	public GetTopResponse getTop() {
		return GetTopResponse.builder()
				.activityRecordMonthlyInfoList(ActivityRecordMonthlyInfo.toRows(AdvFactory.getAdvSeries()))
				.build();
	}

	public PlayAdvDataResponse playAdvData(PlayAdvDataRequest request) {
		return PlayAdvDataResponse.builder().watchRewardList(new ArrayList<>()).build();
	}
}
