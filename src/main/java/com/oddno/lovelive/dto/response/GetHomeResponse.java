package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.archive.FavoriteChannel;
import com.oddno.lovelive.dto.response.archive.LiveInfo;
import com.oddno.lovelive.dto.response.archive.LiveInfoMusicvideo;
import com.oddno.lovelive.dto.response.archive.LiveInfoWithstation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetHomeResponse {

    @JsonProperty("favorite_channel_list")
    private List<FavoriteChannel> favoriteChannelList;

    @JsonProperty("live_archive_list")
    private List<LiveInfo> liveArchiveList;

    @JsonProperty("trailer_archive_list")
    private List<LiveInfo> trailerArchiveList;

    @JsonProperty("recommend_archive_list")
    private List<LiveInfo> recommendArchiveList;

    @JsonProperty("with_station_list")
    private List<LiveInfoWithstation> withStationList;

    @JsonProperty("music_video_list")
    private List<LiveInfoMusicvideo> musicVideoList;

}