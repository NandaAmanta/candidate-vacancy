package com.nanda.candidate_vacancy.modules.candidate.presentation.controller;

import com.nanda.candidate_vacancy.commons.config.APIPrefix;
import com.nanda.candidate_vacancy.modules.candidate.application.CandidateService;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request.CandidateCreationRequest;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request.CandidateUpdateRequest;
import com.nanda.candidate_vacancy.commons.response.ApiResponse;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateResponse;
import com.nanda.candidate_vacancy.modules.candidate.presentation.dto.response.CandidateWithScoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(APIPrefix.CANDIDATE)
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CandidateResponse>>> pagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", candidateService.pagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CandidateResponse>> detail(@PathVariable  UUID id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", candidateService.detail(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CandidateResponse>> create(@RequestBody CandidateCreationRequest candidateCreationRequest) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", candidateService.create(candidateCreationRequest)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CandidateResponse>> update(@PathVariable UUID id, @RequestBody CandidateUpdateRequest candidateupdateRequest) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", candidateService.update(id, candidateupdateRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> delete(@PathVariable UUID id) {
        candidateService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", null));
    }
}
