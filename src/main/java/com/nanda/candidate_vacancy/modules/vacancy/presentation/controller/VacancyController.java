package com.nanda.candidate_vacancy.modules.vacancy.presentation.controller;

import com.nanda.candidate_vacancy.commons.config.APIPrefix;
import com.nanda.candidate_vacancy.commons.response.ApiResponse;
import com.nanda.candidate_vacancy.modules.vacancy.application.VacancyService;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request.VacancyCreationRequest;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.request.VacancyUpdateRequest;
import com.nanda.candidate_vacancy.modules.vacancy.presentation.dto.response.VacancyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(APIPrefix.VACANCY)
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<VacancyResponse>>> pagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", vacancyService.pagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VacancyResponse>> detail(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", vacancyService.detail(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VacancyResponse>> create(@RequestBody VacancyCreationRequest body) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", vacancyService.create(body)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VacancyResponse>> update(@PathVariable UUID id, @RequestBody VacancyUpdateRequest body) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", vacancyService.update(id, body)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", vacancyService.delete(id)));
    }
}
