package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.interfaces.SendBotMessageService;
import com.example.demo.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.demo.util.BotConstants.NOT_FOUND_STUDENT;
import static com.example.demo.util.BotConstants.STUDENT_MESSAGE;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SendBotMessageService sendBotMessageService;

    @Override
    public void saveOrUpdateUserData(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(long chatId) {
        return studentRepository.findStudentByChatId(chatId);
    }

    @Override
    public void conclusionStudentData(long chatId) {
        Optional<Student> studentOptional = studentRepository.findStudentByChatId(chatId);

        studentOptional.ifPresentOrElse(
                student -> {
                    StringBuilder studentMessage = new StringBuilder();
                    studentMessage.append(STUDENT_MESSAGE);
                    studentMessage.append(student).append("\n");
                    sendBotMessageService.prepareAndSendMessage(chatId, studentMessage.toString());
                },
                () -> sendBotMessageService.prepareAndSendMessage(chatId, NOT_FOUND_STUDENT)
        );
    }

    @Override
    @Transactional
    public void deleteStudent(long chatId) {
        studentRepository.deleteStudentByChatId(chatId);
    }
}
