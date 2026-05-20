package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.archive.LiveTimeline;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetFesTimelineDataResponse {

    @JsonProperty("timelines")
    private List<LiveTimeline> timelines;

    @JsonProperty("polling_interval")
    private int pollingInterval;

}