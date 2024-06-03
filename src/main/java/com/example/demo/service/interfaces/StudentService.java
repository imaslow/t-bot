package com.example.demo.service.interfaces;

import com.example.demo.model.Student;

import java.util.Optional;

public interface StudentService {

    void saveOrUpdateUserData(Student student);

    Optional<Student> getStudent(long chatId);

    void conclusionStudentData(long chatId);

    void deleteStudent(long chatId);

}
