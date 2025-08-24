package com.nanda.candidate_vacancy.modules.candidate.infrastructure;

import com.nanda.candidate_vacancy.modules.candidate.domain.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, UUID> {
//    public Page<Candidate> findAll(Pageable pageable);
}
