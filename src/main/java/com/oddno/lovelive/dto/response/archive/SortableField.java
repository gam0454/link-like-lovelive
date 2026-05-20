package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class SortableField {

    @JsonProperty("key")
    private String key;

    @JsonProperty("label")
    private String label;

}