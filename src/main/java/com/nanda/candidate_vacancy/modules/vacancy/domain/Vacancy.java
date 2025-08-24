package com.nanda.candidate_vacancy.modules.vacancy.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document("vacancies")
public class Vacancy {
    @Id
    private UUID id;
    private String name;
    private String description;
    private List<VacancyCriterion> criterions;
}
