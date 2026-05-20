package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class GetFesArchiveDataResponseAllOfEnquetes {

    @JsonProperty("start_time_second")
    private int startTimeSecond;

    @JsonProperty("end_time_second")
    private int endTimeSecond;

}