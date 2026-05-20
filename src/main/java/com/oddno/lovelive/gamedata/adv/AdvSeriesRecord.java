package com.oddno.lovelive.gamedata.adv;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class AdvSeriesRecord {

    private int id;
    private int seasonsId;
    private String name;
    private String description;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private int fiscalYearDisplay;
    private long advAlbumId;
    private int isBadgeDisplayType;
    private String monthText;
    private String yearText;
    private int storySegment;
    
    private transient Map<Integer, AdvDatasRecord> advs = new LinkedHashMap<>();
}