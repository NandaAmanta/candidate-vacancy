package com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CandidateWithScoreResponse {

    private UUID id;
    private String name;
    private String email;
    private int score;

    public static CandidateWithScoreResponse fromCandidate(Candidate candidate , int score) {
        return new CandidateWithScoreResponse(candidate.getId(), candidate.getName(), candidate.getEmail(), score);
    }
}
