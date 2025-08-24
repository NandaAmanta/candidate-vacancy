package com.nanda.candidate_vacancy.modules.candidate.application;

import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import com.nanda.candidate_vacancy.modules.candidate.domain.Gender;
import com.nanda.candidate_vacancy.modules.candidate.infrastructure.CandidateRepository;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request.CandidateCreationRequest;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request.CandidateUpdateRequest;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateResponse;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateWithScoreResponse;
import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.domain.VacancyCriterion;
import com.nanda.candidate_vacancy.modules.vacancy.infrastructure.VacancyRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @Autowired
    private VacancyRepository vacancyRepository;

    public CandidateResponse create(CandidateCreationRequest candidateCreationRequest) {
        Candidate cretedCandidate = candidateRepository.save(candidateCreationRequest.toCandidate());
        return CandidateResponse.fromCandidate(cretedCandidate);
    }

    public Page<CandidateResponse> pagination(int page, int size) {
        return candidateRepository.findAll(PageRequest.of(page,size)).map(CandidateResponse::fromCandidate);
    }

    public CandidateResponse detail(UUID id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        return CandidateResponse.fromCandidate(candidate);
    }

    public CandidateResponse update(UUID id, CandidateUpdateRequest candidateUpdateRequest) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidateUpdateRequest.toCandidate(candidate);
        candidateRepository.save(candidate);
        return CandidateResponse.fromCandidate(candidate);
    }

    public boolean delete(UUID id) {
        candidateRepository.deleteById(id);
        return true;
    }

}
