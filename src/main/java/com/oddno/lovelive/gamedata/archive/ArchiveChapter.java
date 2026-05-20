package com.oddno.lovelive.gamedata.archive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArchiveChapter {

    private String name;
    private int playTimeSecond;
    private boolean isExtra;
    private boolean isAvailable;

}