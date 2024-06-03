package com.example.demo.comands.impl;

import com.example.demo.buttons.ButtonsDeleteData;
import com.example.demo.comands.interfaces.Command;
import com.example.demo.model.Student;
import com.example.demo.service.interfaces.SendBotMessageService;
import com.example.demo.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

import static com.example.demo.util.BotConstants.NOT_FOUND_STUDENT_TO_DELETE;
import static com.example.demo.util.BotConstants.SURE_DELETE;

@Component
@RequiredArgsConstructor
public class DeleteDataCommandImpl implements Command {

    private final StudentService studentService;
    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        long chatId = update.getMessage().getChatId();

        Optional<Student> student = studentService.getStudent(chatId);

        if (student.isPresent()) {
            sendBotMessageService.sendButtonMessage(chatId, SURE_DELETE, ButtonsDeleteData.inlineMarkup());
        } else {
            sendBotMessageService.prepareAndSendMessage(chatId, NOT_FOUND_STUDENT_TO_DELETE);
        }
    }
}
