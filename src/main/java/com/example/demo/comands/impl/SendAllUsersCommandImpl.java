package com.example.demo.comands.impl;

import com.example.demo.comands.interfaces.Command;
import com.example.demo.service.interfaces.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class SendAllUsersCommandImpl implements Command {

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        String text = update.getMessage().getText();
        sendBotMessageService.sendTextToAllUsers(text.substring(text.indexOf(" ")));
    }
}
