package com.oddno.lovelive.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.oddno.lovelive.dto.request.archive.GetArchiveListRequestCharactersInner;
import com.oddno.lovelive.enums.FilterHasWithliveExtra;
import com.oddno.lovelive.enums.FilterHasWithliveExtraAdmission;
import com.oddno.lovelive.enums.FilterLiveType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetArchiveListRequest {

	@JsonProperty("order")
	private OrderEnum order;

	@JsonProperty("season_id")
	private int seasonId;

	@JsonProperty("live_type")
	private FilterLiveType liveType;

	@JsonProperty("has_withlive_extra")
	private FilterHasWithliveExtra hasWithliveExtra;

	@JsonProperty("has_withlive_extra_admission")
	private FilterHasWithliveExtraAdmission hasWithliveExtraAdmission;

	@JsonProperty("characters")
	private List<GetArchiveListRequestCharactersInner> characters;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("sort")
	private String sort;

	public enum OrderEnum {
	    ASC("asc"),
	    DESC("desc");

	    private final String value;

	    OrderEnum(String value) {
	        this.value = value;
	    }

	    @JsonValue
	    public String getValue() {
	        return value;
	    }

	    @JsonCreator
	    public static OrderEnum fromString(String s) {
	        if (s == null) return null;
	        for (OrderEnum type : values()) {
	            if (type.value.equalsIgnoreCase(s)) {
	                return type;
	            }
	        }
	        return null;
	    }
	}
}