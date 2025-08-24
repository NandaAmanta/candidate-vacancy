package com.nanda.candidate_vacancy.modules.vacancy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SalaryRangeDetails {

    @JsonProperty("min_salary")
    private Integer minSalary;

    @JsonProperty("max_salary")
    private Integer maxSalary;
}
