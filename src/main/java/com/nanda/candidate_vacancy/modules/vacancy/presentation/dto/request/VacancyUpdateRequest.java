package com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request;

import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class VacancyUpdateRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;

    private String description;

    private List<VacancyCriterionCreationRequest> criterions;

    public Vacancy toVacancy(Vacancy vacancy) {
        vacancy.setName(name);
        vacancy.setDescription(description);
        vacancy.setCriterions(criterions.stream().map(VacancyCriterionCreationRequest::toVacancy).toList());
        return vacancy;
    }
}
