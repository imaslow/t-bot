package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "personalPronouns")
public class PersonalPronouns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personalPronounsId;

    private String ppSubject;

    private String ppSubjectTranslate;

    private String ppAddition;

    private String ppAdditionTranslate;

    private String example;

    @Override
    public String toString() {
        return
                "pronoun = " + ppSubject + ", " + ppAddition + "\n" +
                        "translate = " + ppSubjectTranslate + ", " + ppAdditionTranslate + "\n" +
                        "example = " + example + "\n";
    }
}
