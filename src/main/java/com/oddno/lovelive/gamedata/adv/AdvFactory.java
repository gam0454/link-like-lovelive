package com.oddno.lovelive.gamedata.adv;

import java.util.LinkedHashMap;
import java.util.Map;

import com.oddno.lovelive.gamedata.MasterdataManager;

import lombok.Getter;

@Getter
public class AdvFactory {

	private static Map<Integer, AdvDatasRecord> advDatas = new LinkedHashMap<>();
	private static Map<Integer, AdvSeriesRecord> advSeries = new LinkedHashMap<>();

	public static void loadData() {
		for (AdvSeriesRecord data : MasterdataManager.load("advseries.tsv", AdvSeriesRecord.class)) {
			advSeries.put(data.getId(), data);
		}
		
		for (AdvDatasRecord data : MasterdataManager.load("advdatas.tsv", AdvDatasRecord.class)) {
			AdvSeriesRecord series = advSeries.get(data.getAdvSeriesId());
			series.getAdvs().put(data.getId(), data);
			advDatas.put(data.getId(), data);
		}
	}
	
	public static Map<Integer, AdvSeriesRecord> getAdvSeries() {
		return advSeries;
	}
}
