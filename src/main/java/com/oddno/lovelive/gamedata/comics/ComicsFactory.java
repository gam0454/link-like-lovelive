package com.oddno.lovelive.gamedata.comics;

import java.util.LinkedHashMap;
import java.util.Map;

import com.oddno.lovelive.gamedata.MasterdataManager;

import lombok.Getter;

@Getter
public class ComicsFactory {

	private static Map<Integer, ComicsRecord> comics = new LinkedHashMap<>();

	public static void loadData() {
		for (ComicsRecord data : MasterdataManager.load("comics.tsv", ComicsRecord.class)) {
			comics.put(data.getId(), data);
		}
	}
	
	public static Map<Integer, ComicsRecord> getComics() {
		return comics;
	}
}
