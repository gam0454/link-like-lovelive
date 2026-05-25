package com.oddno.lovelive.gamedata.sticker;


import java.util.LinkedHashMap;
import java.util.Map;

import com.oddno.lovelive.gamedata.MasterdataManager;

import lombok.Getter;

@Getter
public class StickerFactory {

	private static Map<Integer, StickersRecord> stickers = new LinkedHashMap<>();

	public static void loadData() {
		for (StickersRecord data : MasterdataManager.load("stickers.tsv", StickersRecord.class)) {
			stickers.put(data.getId(), data);
		}
	}
	
	public static Map<Integer, StickersRecord> getStickers() {
		return stickers;
	}
}
