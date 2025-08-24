package com.nanda.candidate_vacancy.modules.vacancy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.candidate.domain.Gender;
import lombok.Data;

@Data
public class GenderDetails {
    private Gender gender;
}
