package com.oddno.lovelive.gamedata.archive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArchiveCharacter {

    private int characterId;
    private boolean isGuest;

}