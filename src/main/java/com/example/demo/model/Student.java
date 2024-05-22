package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "student")
public class Student {

    @Id
    private Long studentId;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "groupName_id")
    private GroupName groupName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private User userChatId;

    @Override
    public String toString() {
        return
                firstName + " " + lastName +
                "\ngroup = " + groupName.getGroupName() +
                "\nteacher = " + teacher.getFirstName() + " " + teacher.getLastName();
    }

}
