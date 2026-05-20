package com.oddno.lovelive.dto.response.activity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.adv.AdvSeriesRecord;

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
public class ActivityRecordMonthlyInfo {

	@JsonProperty("adv_series_id")
	private int advSeriesId;

	@JsonProperty("monthly_title")
	private String monthlyTitle;

	@JsonProperty("monthly_description")
	private String monthlyDescription;

	@JsonProperty("is_monthly_not_watched")
	private boolean isMonthlyNotWatched;

	@JsonProperty("is_current_season")
	private boolean isCurrentSeason;

	@JsonProperty("monthly_start_date")
	private OffsetDateTime monthlyStartDate;

	@JsonProperty("monthly_end_date")
	private OffsetDateTime monthlyEndDate;

	@JsonProperty("adv_info_list")
	private List<AdventureInfo> advInfoList;

	@JsonProperty("is_not_displayed_new_part")
	private boolean isNotDisplayedNewPart;

	public static List<ActivityRecordMonthlyInfo> toRows(Map<Integer, AdvSeriesRecord> series) {
		if (series == null) {
			return null;
		}

		return series.values().stream().map(s -> {
			return ActivityRecordMonthlyInfo.builder()
					.advSeriesId(s.getId())
					.monthlyTitle(s.getName())
					.monthlyDescription(s.getDescription())
					.isMonthlyNotWatched(true)
					.isCurrentSeason(false)
					.monthlyStartDate(s.getStartTime())
					.monthlyEndDate(s.getEndTime())
					.advInfoList(AdventureInfo.toRows(s.getAdvs()))
					.isNotDisplayedNewPart(false)
					.build();
		}).collect(Collectors.toList());
	}
}