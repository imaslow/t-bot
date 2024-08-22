package com.example.demo.repository;

import com.example.demo.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findTravelByTravelIdentifier(String travelIdentifier);

}
