package com.example.demo.service;

import com.example.demo.bot.TelegramBot;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.interfaces.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.demo.util.BotConstants.ERROR_TEXT;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendBotMessageServiceImpl implements SendBotMessageService {

    @Autowired
    @Lazy
    private TelegramBot telegramBotService;
    private final StudentRepository studentRepository;

    @Override
    public void sendButtonMessage(long chatId, String text, InlineKeyboardMarkup replyMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setReplyMarkup(replyMarkup);

        executeMessage(message);
    }

    @Override
    public void sendTextToAllUsers(String textToSend) {
        studentRepository.findAll().forEach(student -> prepareAndSendMessage(student.getChatId(), textToSend));
    }

    @Override
    public void welcomeAndSendMessage(long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you";
        log.info("Replied to user " + name);
        prepareAndSendMessage(chatId, answer);
    }

    @Override
    public void prepareAndSendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        executeMessage(message);
    }

    public void executeMessage(SendMessage message) {
        try {
            telegramBotService.execute(message);
        } catch (TelegramApiException e) {
            log.error(ERROR_TEXT + e.getMessage());
        }
    }
}
