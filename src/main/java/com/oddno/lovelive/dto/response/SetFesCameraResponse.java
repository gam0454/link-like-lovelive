package com.oddno.lovelive.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveCameraType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SetFesCameraResponse {

    @JsonProperty("camera_type")
    private LiveCameraType cameraType;

    @JsonProperty("focus_character_id")
    private int focusCharacterId;

}