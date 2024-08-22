package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelId;

    private String phrase;

    private String translate;

    private String travelIdentifier;

    @Override
    public String toString() {
        return
                phrase + "\n" + translate + "\n" ;

    }

}
