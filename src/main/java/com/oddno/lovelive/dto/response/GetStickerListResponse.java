package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.sticker.StickerInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetStickerListResponse {

    @JsonProperty("sticker_info_list")
    private List<StickerInfo> stickerInfoList;

}