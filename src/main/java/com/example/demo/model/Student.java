package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private Long chatId;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "group_name_id")
    private GroupName groupName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @Override
    public String toString() {
        return
                firstName + " " + lastName +
                        "\ngroup = " + groupName.getGroupName() +
                        "\nemail = " + email +
                        "\nteacher = " + teacher.getFirstName() + " " + teacher.getLastName();
    }

}
