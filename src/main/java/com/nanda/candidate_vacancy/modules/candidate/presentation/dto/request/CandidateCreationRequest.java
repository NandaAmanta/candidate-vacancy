package com.nanda.candidate_vacancy.modules.candidate.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import com.nanda.candidate_vacancy.modules.candidate.domain.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
public class CandidateCreationRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Birth date cannot be empty")
    @JsonProperty("birth_date")
    private String birthDate;

    @NotNull(message = "Gender cannot be empty")
    @Pattern(regexp = "MALE|FEMALE", message = "Gender must be MALE or FEMALE")
    private String gender;

    @JsonProperty("current_salary")
    @Min(value = 0, message = "Current salary cannot be negative")
    private float currentSalary;

    public Candidate toCandidate() {
        var birthDate = LocalDate.parse(this.birthDate);
        Candidate candidate = new Candidate();
        candidate.setId(UUID.randomUUID());
        candidate.setName(this.name);
        candidate.setEmail(this.email);
        candidate.setBirthDate(birthDate);
        candidate.setGender(Gender.valueOf(this.gender));
        candidate.setCurrentSalary(this.currentSalary);
        return candidate;
    }
}
