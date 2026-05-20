package com.oddno.lovelive.gamedata.card;

import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class CharactersRecord {

	private int id;
	private String nameLast;
	private String nameFirst;
	private String latinAlphabetNameLast;
	private String latinAlphabetNameFirst;
	private int generationsId;
	private int seriesType;
	private int iconOrderId;
	private String characterVoice;
	private String themeColor;
	private String introduction;
	private OffsetDateTime showSeasonFanLvStartTime;
	private OffsetDateTime showSeasonFanLvEndTime;
	private int isExistFanLv;
	private int styleType;
	private int printFilterType;
	private String displayFullName;
	private String latinAlpabetFullName;
	private int nameDisplayType;
	private String displayGeneration;
	private String graduateIntroduction;
	private String containedCharacters;
	private int memberProfileCategoryId;
	private int memberProfileOrder;
	private int isShowOnlyCardList;
	private int[] createContainedCharactersArray;
}
