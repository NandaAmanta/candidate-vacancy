package com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.vacancy.domain.CriterionType;
import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.domain.VacancyCriterion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class VacancyCriterionCreationRequest {
    @NotNull(message = "type cannot be empty")
    @Pattern(regexp = "AGE|GENDER|SALARY_RANGE", message = "type must be AGE, GENDER or SALARY_RANGE")
    private String type;
    private Map<String, Object> details;
    private int weight = 0;

    public VacancyCriterion toVacancy() {
        VacancyCriterion vacancyCriterion = new VacancyCriterion();
        vacancyCriterion.setType(CriterionType.valueOf(type));
        vacancyCriterion.setDetails(details);
        vacancyCriterion.setWeight(weight);
        return vacancyCriterion;
    }
}
