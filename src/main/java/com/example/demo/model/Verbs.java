package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "verbs")
public class Verbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verbsId;

    private String infinitive;

    private String simplePast;

    private String pastParticiple;

    private String translate;

    @Override
    public String toString() {
        return
                infinitive + ",  " + simplePast + ",  " + pastParticiple + '\n' +
                        "- " + translate + "\n";
    }
}
