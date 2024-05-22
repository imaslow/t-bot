//package com.example.demo.service;
//
//import com.example.demo.handle.MessageHandler;
//import com.example.demo.model.Student;
//import com.example.demo.repository.StudentRepository;
//import com.example.demo.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static com.example.demo.util.BotConstants.STUDENT_MESSAGE;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final StudentRepository studentRepository;
//    private final MessageHandler messageHandler;
//    private final UserRepository userRepository;
//
//    public void handleUserDataCommand(long chatId) {
//        List<Student> students = studentRepository.findAll();
//        StringBuilder studentMessage = new StringBuilder();
//        studentMessage.append(STUDENT_MESSAGE);
//
//        for (Student student : students) {
//            if (student.getUserChatId().getChatId().equals(chatId)) {
//                studentMessage.append(student).append("\n");
//                messageHandler.prepareAndSendMessage(chatId, studentMessage.toString());
//                break;
//            }
//        }
//    }
//
//    public void sendTextToAllUsers(String textToSend) {
//        userRepository.findAll().forEach(user -> messageHandler.prepareAndSendMessage(user.getChatId(), textToSend));
//    }
//
//}
