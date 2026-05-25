package com.oddno.lovelive.dto.response.comics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class GetGallaryListResponseGallaryInfoListInner {

    @JsonProperty("comics_id")
    private int comicsId;

    @JsonProperty("name")
    private String name;

}