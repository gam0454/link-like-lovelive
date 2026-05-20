package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class ArchiveWithliveChapter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("play_time_second")
    private int playTimeSecond;

    @JsonProperty("is_extra")
    private boolean isExtra;

}