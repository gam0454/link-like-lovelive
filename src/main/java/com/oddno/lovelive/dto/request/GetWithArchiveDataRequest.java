package com.oddno.lovelive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GetWithArchiveDataRequest {

    @JsonProperty("archives_id")
    private String archivesId;

}