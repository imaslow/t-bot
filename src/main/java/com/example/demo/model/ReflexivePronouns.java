package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "reflexivePronouns")
public class ReflexivePronouns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reflexivePronounsId;

    @OneToOne
    @JoinColumn(name = "pp_subject")
    private PersonalPronouns personalPronouns;

    private String reflexivePronouns;

    private String example;

    @Override
    public String toString() {
        return
                "pronoun = " + personalPronouns.getPpSubject() + ", " + reflexivePronouns + "\n" +
                        "example = " + example + "\n";
    }
}
