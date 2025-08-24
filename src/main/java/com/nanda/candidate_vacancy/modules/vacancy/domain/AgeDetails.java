package com.nanda.candidate_vacancy.modules.vacancy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AgeDetails {

    @JsonProperty("min_age")
    private Integer minAge;

    @JsonProperty("max_age")
    private Integer maxAge;
}
