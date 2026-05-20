package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.archive.FilterableCharacter;
import com.oddno.lovelive.dto.response.archive.LiveInfo;
import com.oddno.lovelive.dto.response.archive.SortableField;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetArchiveListResponse {

    @JsonProperty("archive_list")
    private List<LiveInfo> archiveList;

    @JsonProperty("filterable_characters")
    private List<FilterableCharacter> filterableCharacters;

    @JsonProperty("sortable_fields")
    private List<SortableField> sortableFields;

}