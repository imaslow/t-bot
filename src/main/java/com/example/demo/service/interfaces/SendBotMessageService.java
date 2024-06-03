package com.example.demo.service.interfaces;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SendBotMessageService {

    void prepareAndSendMessage(long chatId, String message);

    void sendButtonMessage(long chatId, String text, InlineKeyboardMarkup replyMarkup);

    void welcomeAndSendMessage(long chatId, String name);

    void sendTextToAllUsers(String textToSend);

}
