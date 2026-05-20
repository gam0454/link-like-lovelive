package com.oddno.lovelive.gamedata.card;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.oddno.lovelive.gamedata.MasterdataManager;

import lombok.Getter;

@Getter
public class CardFactory {

	private static Map<Integer, CardDatasRecord> cardDatas = new LinkedHashMap<>();
	private static Map<Integer, CharactersRecord> characters = new LinkedHashMap<>();
	private static Map<Integer, CardSeriesRecord> cardSeries = new LinkedHashMap<>();
	private static Map<Integer, List<StyleMoviesRecord>> styleMovies = new LinkedHashMap<>();
	private static Map<Integer, List<StyleVoicesRecord>> styleVoices = new LinkedHashMap<>();

	public static void loadData() {
		for (CardDatasRecord data : MasterdataManager.load("carddatas.tsv", CardDatasRecord.class)) {
			cardDatas.put(data.getId(), data);
		}
		for (CharactersRecord data : MasterdataManager.load("characters.tsv", CharactersRecord.class)) {
			characters.put(data.getId(), data);
		}
		for (CardSeriesRecord data : MasterdataManager.load("cardseries.tsv", CardSeriesRecord.class)) {
			cardSeries.put(data.getId(), data);
		}
		for (StyleMoviesRecord data : MasterdataManager.load("stylemovies.tsv", StyleMoviesRecord.class)) {
			styleMovies.computeIfAbsent(data.getCardSeriesId(), k -> new ArrayList<>()).add(data);
		}
		for (StyleVoicesRecord data : MasterdataManager.load("stylevoices.tsv", StyleVoicesRecord.class)) {
			styleVoices.computeIfAbsent(data.getCardSeriesId(), k -> new ArrayList<>()).add(data);
		}
	}
	
	public static Map<Integer, CardDatasRecord> getCardDatas() {
		return cardDatas;
	}
	
	public static CharactersRecord getCharacter(int id) {
		return characters.get(id);
	}
	
	public static List<StyleMoviesRecord> getStyleMovie(int id) {
		return styleMovies.get(id);
	}
	
	public static List<StyleVoicesRecord> getStyleVoice(int id) {
		return styleVoices.get(id);
	}
}
