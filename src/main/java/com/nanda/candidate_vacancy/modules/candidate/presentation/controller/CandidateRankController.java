package com.nanda.candidate_vacancy.modules.candidate.presentation.controller;

import com.nanda.candidate_vacancy.commons.config.APIPrefix;
import com.nanda.candidate_vacancy.commons.response.ApiResponse;
import com.nanda.candidate_vacancy.modules.candidate.application.CandidateRankService;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateWithScoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(APIPrefix.CANDIDATE_RANK)
public class CandidateRankController {

    @Autowired
    private CandidateRankService candidateRankService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CandidateWithScoreResponse>>> rank(@RequestParam(name = "vacancy_id" ) UUID vacancyId) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", candidateRankService.rank(vacancyId)));
    }
}
