package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private LocalDateTime dateTime;

    private String dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);

        return "Занятие #" + scheduleId +
                "\nДата и время: " + formattedDateTime +
                "\nДень недели: " + dayOfWeek +
                "\nПреподаватель: " + teacher.getFirstName() + " " + teacher.getLastName() +
                "\nСтатус преподавателя: " + teacher.getStatus().getStatus();
    }
}
