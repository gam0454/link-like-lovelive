package com.oddno.lovelive.dto.response.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.gamedata.card.CardDatasRecord;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCardData {

	@JsonProperty("d_card_datas_id")
	private String dCardDatasId;

	@JsonProperty("card_datas_id")
	private int cardDatasId;

	@JsonProperty("card_name")
	private String cardName;

	@JsonProperty("style_level")
	private long styleLevel;

	@JsonProperty("max_style_level")
	private long maxStyleLevel;

	@JsonProperty("limit_break_times")
	private long limitBreakTimes;

	@JsonProperty("max_limit_break_times")
	private long maxLimitBreakTimes;

	@JsonProperty("card_parameters")
	private CardParameters cardParameters;

	@JsonProperty("skill_list")
	private List<SkillData> skillList;

	@JsonProperty("character_id")
	private int characterId;

	@JsonProperty("generations_id")
	private int generationsId;

	@JsonProperty("series_type")
	private long seriesType;

	@JsonProperty("card_sort_order")
	private long cardSortOrder;

	@JsonProperty("character_bonus")
	private CharacterBonus characterBonus;

	@JsonProperty("is_evolve_possible")
	private boolean isEvolvePossible;

	@JsonProperty("is_evolve_max")
	private boolean isEvolveMax;

	@JsonProperty("member_fan_level")
	private long memberFanLevel;

	@JsonProperty("is_limit_break")
	private boolean isLimitBreak;

	@JsonProperty("is_style_level_up")
	private boolean isStyleLevelUp;

	@JsonProperty("rhythm_game_skill_list")
	private List<RhythmGameSkillData> rhythmGameSkillList;

	@JsonProperty("display_card_id")
	private long displayCardId;

	@JsonProperty("parallel_card_datas_id")
	private long parallelCardDatasId;

	public static List<UserCardData> toRows(Map<Integer, CardDatasRecord> cards) {
		if (cards == null) {
			return null;
		}

		return cards.values().stream().map(card -> {
			return UserCardData.builder()
					.dCardDatasId(UUID.randomUUID().toString())
					.cardDatasId(card.getId())
					.cardName(card.getName())
					.styleLevel(card.getStyle())
					.maxStyleLevel(30)
					.limitBreakTimes(4)
					.cardParameters(CardParameters.builder()
							.smile(card.getInitialSmile())
							.pure(card.getInitialPure())
							.cool(card.getInitialCool())
							.mental(card.getInitialMental())
							.build())
					.skillList(new ArrayList<>())
					.characterId(card.getCharactersId())
					.generationsId(card.getCharactersId() / 10)
					.seriesType(0)
					.cardSortOrder(0)
					.characterBonus(CharacterBonus.builder()
							.characterId(card.getCharactersId())
							.musicMasteryBonus(12)
							.loveCorrectionValue(60)
							.musicMasteryBonusList(new ArrayList<>())
							.seasonFanLevel(1)
							.build())
					.isEvolvePossible(false)
					.isEvolveMax(false)
					.memberFanLevel(1)
					.isLimitBreak(false)
					.isStyleLevelUp(false)
					.rhythmGameSkillList(new ArrayList<>())
					.build();
		}).collect(Collectors.toList());
	}

}