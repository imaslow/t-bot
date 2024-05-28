package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "possessivePronouns")
public class PossessivePronouns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long possessivePronounsId;

    @OneToOne
    @JoinColumn(name = "pp_subject")
    private PersonalPronouns personalPronouns;

    private String possessiveAdjectives;

    private String possessivePronouns;

    private String translate;

    private String example;

    @Override
    public String toString() {
        return
                "pronoun = " + personalPronouns.getPpSubject() + ", " + possessiveAdjectives + ", " + possessivePronouns + "\n" +
                        "translate = " + translate + "\n" +
                        "example = " + example + "\n";
    }
}
