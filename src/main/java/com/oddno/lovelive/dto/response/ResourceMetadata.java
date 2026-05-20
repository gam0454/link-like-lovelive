package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class ResourceMetadata {

    @JsonProperty("path")
    private String path;

    @JsonProperty("room_id")
    private String roomId;

    @JsonProperty("playlist_file")
    private String playlistFile;

    @JsonProperty("live_started_at")
    private String liveStartedAt;

    @JsonProperty("joined_room_at")
    private String joinedRoomAt;
}