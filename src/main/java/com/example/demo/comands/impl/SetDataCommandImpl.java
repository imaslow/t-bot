package com.example.demo.comands.impl;

import com.example.demo.comands.interfaces.Command;
import com.example.demo.comands.interfaces.SetDataCommand;
import com.example.demo.enums.BotState;
import com.example.demo.handle.UserState;
import com.example.demo.model.GroupName;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.interfaces.SendBotMessageService;
import com.example.demo.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

import static com.example.demo.enums.BotState.WAITING_FOR_FIRST_NAME;
import static com.example.demo.util.BotConstants.*;

@Component
@RequiredArgsConstructor
public class SetDataCommandImpl implements Command, SetDataCommand {

    private final SendBotMessageService sendBotMessageService;
    private final StudentService studentService;
    private final UserState userState;

    Student newStudent = new Student();

    @Override
    public void processFirstName(long chatId, Update update) {
        String message = update.getMessage().getText();

        newStudent.setChatId(chatId);
        newStudent.setFirstName(message);
        userState.setUserState(chatId, BotState.WAITING_FOR_LAST_NAME);
        sendBotMessageService.prepareAndSendMessage(chatId, ENTER_LAST_NAME);
    }

    @Override
    public void processLastName(long chatId, Update update) {
        String message = update.getMessage().getText();

        newStudent.setLastName(message);
        userState.setUserState(chatId, BotState.WAITING_FOR_EMAIL);
        sendBotMessageService.prepareAndSendMessage(chatId, ENTER_EMAIL);
    }

    @Override
    public void processEmail(long chatId, Update update) {
        String message = update.getMessage().getText();

        newStudent.setEmail(message);
        newStudent.setGroupName(new GroupName().setGroupId(1L));
        newStudent.setTeacher(new Teacher().setTeacherId(1L));
        userState.clearUserState(chatId);
        studentService.saveOrUpdateUserData(newStudent);
        sendBotMessageService.prepareAndSendMessage(chatId, DATE_SAVED);
    }

    @Override
    public void execute(Update update) {
        long chatId = update.getMessage().getChatId();

        Optional<Student> student = studentService.getStudent(chatId);

        if (student.isEmpty()) {
            sendBotMessageService.prepareAndSendMessage(chatId, ENTER_FIRST_NAME);
            userState.setUserState(update.getMessage().getChatId(), WAITING_FOR_FIRST_NAME);
        } else {
            sendBotMessageService.prepareAndSendMessage(chatId, ERROR_SET_DATA);
        }
    }
}