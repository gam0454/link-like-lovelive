package com.oddno.lovelive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.oddno.lovelive.gamedata.adv.AdvFactory;
import com.oddno.lovelive.gamedata.archive.ArchiveFactory;
import com.oddno.lovelive.gamedata.card.CardFactory;
import com.oddno.lovelive.gamedata.comics.ComicsFactory;
import com.oddno.lovelive.gamedata.sticker.StickerFactory;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LinkLikeLoveliveApplication {

	public static void main(String[] args) {
		AdvFactory.loadData();
		ArchiveFactory.loadData();
		CardFactory.loadData();
		ComicsFactory.loadData();
		StickerFactory.loadData();
		
		SpringApplication.run(LinkLikeLoveliveApplication.class, args);
	}

}
