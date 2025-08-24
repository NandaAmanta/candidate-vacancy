package com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.response;

import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.domain.VacancyCriterion;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class VacancyResponse {

    private UUID id;
    private String name;
    private String description;
    private List<VacancyCriterion> criterions;

    public static VacancyResponse fromVacancy(Vacancy vacancy) {
        VacancyResponse response = new VacancyResponse();
        response.setId(vacancy.getId());
        response.setName(vacancy.getName());
        response.setDescription(vacancy.getDescription());
        response.setCriterions(vacancy.getCriterions());
        return response;
    }
}
