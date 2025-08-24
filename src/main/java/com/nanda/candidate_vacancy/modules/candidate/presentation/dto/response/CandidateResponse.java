package com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CandidateResponse {

    private UUID id;
    private String name;
    private String email;

    @JsonProperty("birth_date")
    private String birthDate;
    private String gender;

    @JsonProperty("current_salary")
    private float currentSalary;

    public static CandidateResponse fromCandidate(Candidate candidate) {
        return new CandidateResponse(candidate.getId(), candidate.getName(), candidate.getEmail(), candidate.getBirthDate().toString(), candidate.getGender().toString(), candidate.getCurrentSalary());
    }
}
