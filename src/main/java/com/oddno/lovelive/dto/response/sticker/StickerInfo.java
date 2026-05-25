package com.oddno.lovelive.dto.response.sticker;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.CategoryName;
import com.oddno.lovelive.enums.CategoryType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StickerInfo {

    @JsonProperty("stickers_id")
    private int stickersId;

    @JsonProperty("category_type")
    private CategoryType categoryType;

    @JsonProperty("category_name")
    private CategoryName categoryName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("text")
    private String text;

    @JsonProperty("character_id")
    private int characterId;

    @JsonProperty("is_variant")
    private int isVariant;

    @JsonProperty("season_id")
    private int seasonId;

    @JsonProperty("requirement_text")
    private String requirementText;

    @JsonProperty("requirement_num")
    private long requirementNum;

    @JsonProperty("requirement_progress")
    private long requirementProgress;

    @JsonProperty("variant_requirement_text")
    private String variantRequirementText;

    @JsonProperty("variant_requirement_num")
    private long variantRequirementNum;

    @JsonProperty("variant_requirement_progress")
    private long variantRequirementProgress;

    @JsonProperty("is_owned")
    private boolean isOwned;

    @JsonProperty("is_available_variant")
    private boolean isAvailableVariant;

    @JsonProperty("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private OffsetDateTime createTime;

}