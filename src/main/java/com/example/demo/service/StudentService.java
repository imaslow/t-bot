package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveOrUpdateUserData(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(long chatId) {
        return studentRepository.findStudentByChatId(chatId);
    }

}
