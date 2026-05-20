package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FavoriteChannel {

    @JsonProperty("live_channels_id")
    private int liveChannelsId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_watched")
    private boolean isWatched;

}