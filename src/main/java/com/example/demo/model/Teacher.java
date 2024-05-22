package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "teacher")
public class Teacher {

    @Id
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
