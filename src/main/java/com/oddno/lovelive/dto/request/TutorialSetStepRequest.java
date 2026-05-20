package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class TutorialSetStepRequest {

    @JsonProperty("tutorial_id")
    private boolean tutorialId;
}