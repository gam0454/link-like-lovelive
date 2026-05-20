package com.oddno.lovelive.dto.response.archive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.WithliveEnqueteStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WithliveEnquete {

    @JsonProperty("enquete_id")
    private String enqueteId;

    @JsonProperty("status")
    private WithliveEnqueteStatus status;

    @JsonProperty("question")
    private String question;

    @JsonProperty("selected_option_id")
    private String selectedOptionId;

    @JsonProperty("options")
    private List<WithliveEnqueteOption> options;

}