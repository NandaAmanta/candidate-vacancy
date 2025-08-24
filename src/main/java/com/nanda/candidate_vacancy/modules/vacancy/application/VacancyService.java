package com.nanda.candidate_vacancy.modules.vacancy.application;

import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.infrastructure.VacancyRepository;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request.VacancyCreationRequest;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request.VacancyUpdateRequest;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.response.VacancyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository repository;

    public Page<VacancyResponse> pagination(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(VacancyResponse::fromVacancy);
    }

    public VacancyResponse detail(UUID id) {
        return VacancyResponse.fromVacancy(repository.findById(id).orElseThrow());
    }

    public VacancyResponse create(VacancyCreationRequest request) {
        return VacancyResponse.fromVacancy(repository.save(request.toVacancy()));
    }

    public VacancyResponse update(UUID id, VacancyUpdateRequest request) {
        Vacancy vacancy = repository.findById(id).orElseThrow();
        return VacancyResponse.fromVacancy(repository.save(request.toVacancy(vacancy)));
    }

    public boolean delete(UUID id) {
        repository.deleteById(id);
        return true;
    }
}
