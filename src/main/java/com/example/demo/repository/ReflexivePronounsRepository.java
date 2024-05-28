package com.example.demo.repository;

import com.example.demo.model.ReflexivePronouns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReflexivePronounsRepository extends JpaRepository<ReflexivePronouns, Long> {
}
