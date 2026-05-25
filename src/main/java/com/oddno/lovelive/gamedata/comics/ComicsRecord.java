package com.oddno.lovelive.gamedata.comics;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class ComicsRecord {

    private int id;
    private String name;
    private int viewType;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private int tabListId;
    private List<Integer> appearanceCharacterIds;

}