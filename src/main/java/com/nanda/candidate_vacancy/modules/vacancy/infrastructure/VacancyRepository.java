package com.nanda.candidate_vacancy.modules.vacancy.infrastructure;

import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface VacancyRepository extends MongoRepository<Vacancy, UUID> {
    Page<Vacancy> findAll(Pageable pageable);
}
