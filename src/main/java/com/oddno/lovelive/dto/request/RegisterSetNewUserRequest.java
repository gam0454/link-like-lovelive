package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.PlatformType;

import lombok.Getter;

@Getter
public class RegisterSetNewUserRequest {

    @JsonProperty("platform_type")
    private PlatformType platformType;

    @JsonProperty("name")
    private String name;
}