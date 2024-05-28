package com.example.demo.repository;

import com.example.demo.model.Verbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerbsRepository extends JpaRepository<Verbs, Long> {
}
