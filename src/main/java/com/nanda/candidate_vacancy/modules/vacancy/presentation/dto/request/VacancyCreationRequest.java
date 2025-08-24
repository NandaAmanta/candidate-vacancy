package com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request;

import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.domain.VacancyCriterion;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class VacancyCreationRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;

    private String description;

    private List<VacancyCriterionCreationRequest> criterions;

    public Vacancy toVacancy() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(UUID.randomUUID());
        vacancy.setName(name);
        vacancy.setDescription(description);
        vacancy.setCriterions(criterions.stream().map(VacancyCriterionCreationRequest::toVacancy).toList());

        return vacancy;
    }
}
