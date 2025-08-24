package com.nanda.candidate_vacancy.modules.vacancy.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Data
public class VacancyCriterion {

    private CriterionType type;
    private Map<String, Object> details;
    private int weight = 0;
}
