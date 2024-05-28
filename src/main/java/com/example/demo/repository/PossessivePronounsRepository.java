package com.example.demo.repository;

import com.example.demo.model.PossessivePronouns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossessivePronounsRepository extends JpaRepository<PossessivePronouns, Long> {
}
