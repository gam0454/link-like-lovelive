package com.oddno.lovelive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.oddno.lovelive.gamedata.adv.AdvFactory;
import com.oddno.lovelive.gamedata.archive.ArchiveFactory;
import com.oddno.lovelive.gamedata.card.CardFactory;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LinkLikeLoveliveApplication {

	public static void main(String[] args) {
		AdvFactory.loadData();
		CardFactory.loadData();
		ArchiveFactory.loadData();
		SpringApplication.run(LinkLikeLoveliveApplication.class, args);
	}

}
