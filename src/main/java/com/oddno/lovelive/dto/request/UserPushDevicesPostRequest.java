package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.ServiceEnum;

import lombok.Getter;

@Getter
public class UserPushDevicesPostRequest {

    @JsonProperty("service")
    private ServiceEnum service;

    @JsonProperty("token")
    private String token;
}