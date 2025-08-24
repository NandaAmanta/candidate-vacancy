package com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import com.nanda.candidate_vacancy.modules.candidate.domain.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CandidateUpdateRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Birth date cannot be empty")
    @JsonProperty("birth_date")
    private String birthDate;

    @NotNull(message = "Gender cannot be empty")
    private String gender;

    @JsonProperty("current_salary")
    @Min(value = 0, message = "Current salary cannot be negative")
    private float currentSalary;

    public Candidate toCandidate(Candidate candidate) {
        var birthDate = LocalDate.parse(this.birthDate);
        candidate.setName(this.name);
        candidate.setEmail(this.email);
        candidate.setBirthDate(birthDate);
        candidate.setGender(Gender.valueOf(this.gender));
        candidate.setCurrentSalary(this.currentSalary);
        return candidate;
    }
}
