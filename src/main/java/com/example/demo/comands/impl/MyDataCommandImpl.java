package com.example.demo.comands.impl;

import com.example.demo.comands.interfaces.Command;
import com.example.demo.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class MyDataCommandImpl implements Command {


    private final StudentService studentService;

    @Override
    public void execute(Update update) {
        studentService.conclusionStudentData(update.getMessage().getChatId());
    }
}
