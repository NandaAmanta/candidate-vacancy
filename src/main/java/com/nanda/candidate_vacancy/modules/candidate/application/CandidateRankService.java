package com.nanda.candidate_vacancy.modules.candidate.application;

import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import com.nanda.candidate_vacancy.modules.candidate.domain.Gender;
import com.nanda.candidate_vacancy.modules.candidate.infrastructure.CandidateRepository;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateWithScoreResponse;
import com.nanda.candidate_vacancy.modules.vacancy.domain.Vacancy;
import com.nanda.candidate_vacancy.modules.vacancy.domain.VacancyCriterion;
import com.nanda.candidate_vacancy.modules.vacancy.infrastructure.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CandidateRankService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public List<CandidateWithScoreResponse> rank(UUID vacancyId) {
        /**
         * TODO : This can be optimized
         */
        List<Candidate> listCandidates = candidateRepository.findAll();
        Vacancy vacancy = vacancyRepository.findById(vacancyId).orElseThrow();
        List<CandidateWithScoreResponse> candidateWithScoreResponses = new ArrayList<>();
        listCandidates.forEach(candidate -> {
            CandidateWithScoreResponse candidateWithScoreResponse = CandidateWithScoreResponse.fromCandidate(candidate, 0);
            vacancy.getCriterions().forEach(vacancyCriterion -> {
                calculateScore(candidate, vacancyCriterion, candidateWithScoreResponse);
            });
            candidateWithScoreResponses.add(candidateWithScoreResponse);
        });
        candidateWithScoreResponses.sort((o1, o2) -> o2.getScore() - o1.getScore());
        return candidateWithScoreResponses;
    }

    private void calculateScore(Candidate candidate, VacancyCriterion vacancyCriterion, CandidateWithScoreResponse candidateWithScoreResponse) {
        Map<String, Object> details = (Map<String, Object>) vacancyCriterion.getDetails();
        switch (vacancyCriterion.getType()) {
            case AGE:
                LocalDate birthDate = candidate.getBirthDate();
                int minAge = (Integer)details.get("min_age");
                int maxAge = (Integer)details.get("max_age");
                int currentAge = LocalDate.now().getYear() - birthDate.getYear();
                if(currentAge >= minAge && currentAge <= maxAge) {
                    candidateWithScoreResponse.setScore(candidateWithScoreResponse.getScore() + vacancyCriterion.getWeight());
                }
                break;
            case GENDER:
                Gender vacationGender = Gender.valueOf((String) details.get("gender"));
                if (vacationGender.equals(candidate.getGender())) {
                    candidateWithScoreResponse.setScore(candidateWithScoreResponse.getScore() + vacancyCriterion.getWeight());
                }
                break;
            case SALARY_RANGE:
                float currentSalary = candidate.getCurrentSalary();
                int minSalary = (Integer) details.get("min_salary");
                int maxSalary = (Integer) details.get("max_salary");
                if (currentSalary >= minSalary && currentSalary <= maxSalary) {
                    candidateWithScoreResponse.setScore(candidateWithScoreResponse.getScore() + vacancyCriterion.getWeight());
                }
                break;
            // Add more cases
        }
    }
}
