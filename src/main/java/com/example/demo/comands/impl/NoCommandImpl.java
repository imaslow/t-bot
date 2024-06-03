package com.example.demo.comands.impl;

import com.example.demo.comands.interfaces.Command;
import com.example.demo.service.interfaces.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.demo.util.BotConstants.NO_MESSAGE;

@RequiredArgsConstructor
public class NoCommandImpl implements Command {

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.prepareAndSendMessage(update.getMessage().getChatId(), NO_MESSAGE);
    }
}
