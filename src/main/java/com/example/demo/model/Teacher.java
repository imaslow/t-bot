package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity(name = "teacher")
@Accessors(chain = true)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Override
    public String toString() {
        return "Преподаватель #" + teacherId +
                "\nИмя: " + firstName +
                "\nФамилия: " + lastName +
                "\nСтатус: " + status.getStatus();
    }
}
