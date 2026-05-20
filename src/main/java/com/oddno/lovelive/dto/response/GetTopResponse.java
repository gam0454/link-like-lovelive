package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.activity.ActivityRecordMonthlyInfo;

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
public class GetTopResponse {

	@JsonProperty("activity_record_monthly_info_list")
	private List<ActivityRecordMonthlyInfo> activityRecordMonthlyInfoList;
}
