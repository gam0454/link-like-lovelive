package com.oddno.lovelive.gamedata.sticker;

import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class StickersRecord {

    private int id;
    private String name;
    private String text;
    private int categoryType;
    private int categoryName;
    private int seasonId;
    private int charactersId;
    private int priority;
    private int isVariant;
    private int requirementType;
    private String requirementDetail;
    private int requirementValue;
    private String requirementText;
    private int editRequirementType;
    private String editRequirementDetail;
    private int editRequirementValue;
    private String editRequirementText;
    private int isVisibleOnlyPossess;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private OffsetDateTime availableStartTime;
    private OffsetDateTime availableEndTime;
    private OffsetDateTime variantStartTime;
    private OffsetDateTime variantEndTime;
}