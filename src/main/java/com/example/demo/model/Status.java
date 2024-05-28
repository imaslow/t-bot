package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "status")
public class Status {

    @Id
    private Long statusId;

    private String status;

    @Override
    public String toString() {
        return "Статус #" + statusId +
                "\nСтатус: " + status;
    }
}
