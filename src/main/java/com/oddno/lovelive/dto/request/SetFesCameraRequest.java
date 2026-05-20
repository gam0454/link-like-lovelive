package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveCameraType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SetFesCameraRequest {

    @JsonProperty("live_id")
    private String liveId;

    @JsonProperty("camera_type")
    private LiveCameraType cameraType;

    @JsonProperty("focus_character_id")
    private int focusCharacterId;

}