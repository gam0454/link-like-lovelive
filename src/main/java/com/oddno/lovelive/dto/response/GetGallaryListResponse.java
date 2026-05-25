package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.comics.GetGallaryListResponseGallaryInfoListInner;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetGallaryListResponse {

    @JsonProperty("gallary_info_list")
    private List<GetGallaryListResponseGallaryInfoListInner> gallaryInfoList;

}