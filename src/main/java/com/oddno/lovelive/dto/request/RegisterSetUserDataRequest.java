package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RegisterSetUserDataRequest {

    @JsonProperty("name")
    private String name;
}