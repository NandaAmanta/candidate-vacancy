package com.nanda.candidate_vacancy.modules.candidate.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "candidates")
public class Candidate {

    @Id
    private UUID id;
    private String name;

    @Indexed(unique = true)
    private String email;

    @Field("birth_date")
    private LocalDate birthDate;
    private Gender gender;

    @Field("current_salary")
    private float currentSalary;
}
