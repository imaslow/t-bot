package com.example.demo.comands.impl;

import com.example.demo.buttons.ButtonsStartMessage;
import com.example.demo.comands.interfaces.Command;
import com.example.demo.registr.RegisterUser;
import com.example.demo.service.interfaces.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.demo.util.BotConstants.BUTTON_START_MESSAGE;

@RequiredArgsConstructor
public class StartCommandImpl implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final RegisterUser registerUser;

    @Override
    public void execute(Update update) {
        registerUser.register(update.getMessage());
        sendBotMessageService.welcomeAndSendMessage(update.getMessage().getChatId(), update.getMessage().getChat().getFirstName());
        sendBotMessageService.sendButtonMessage(update.getMessage().getChatId(), BUTTON_START_MESSAGE, ButtonsStartMessage.inlineMarkup());
    }
}
