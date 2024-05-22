//package com.example.demo.handle;
//
//import com.example.demo.buttons.ButtonsStartMessage;
//import com.example.demo.registr.RegisterUser;
//import com.example.demo.service.TelegramBotService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import static com.example.demo.util.BotConstants.BUTTON_START_MESSAGE;
//import static com.example.demo.util.BotConstants.ERROR_TEXT;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class MessageHandler extends TelegramLongPollingBot{
//
//    private final RegisterUser registerUser;
//
//    public void executeMessage(SendMessage message) {
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            log.error(ERROR_TEXT + e.getMessage());
//        }
//    }
//
//    public void prepareAndSendMessage(long chatId, String textToSend) {
//        SendMessage message = new SendMessage();
//        message.setChatId(String.valueOf(chatId));
//        message.setText(textToSend);
//        executeMessage(message);
//    }
//
//    public void welcomeAndSendMessage(long chatId, String name) {
//
//        String answer = "Hi, " + name + ", nice to meet you";
//        log.info("Replied to user " + name);
//        prepareAndSendMessage(chatId, answer);
//
//    }
//
//    public void handleStartMessage(Message message) {
//        registerUser.register(message);
//        welcomeAndSendMessage(message.getChatId(), message.getChat().getFirstName());
//        sendButtonMessage(message.getChatId(), BUTTON_START_MESSAGE, ButtonsStartMessage.inlineMarkup());
//    }
//
//    public void sendButtonMessage(long chatId, String text, InlineKeyboardMarkup replyMarkup) {
//        SendMessage message = new SendMessage();
//        message.setChatId(String.valueOf(chatId));
//        message.setText(text);
//        message.setReplyMarkup(replyMarkup);
//
//        executeMessage(message);
//    }
//
//    @Override
//    public String getBotUsername() {
//        return null;
//    }
//
//    @Override
//    public String getBotToken() {
//        return null;
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//
//    }
//}
