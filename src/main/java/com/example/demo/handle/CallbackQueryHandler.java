//package com.example.demo.handle;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
//
//@Component
//@RequiredArgsConstructor
//public class CallbackQueryHandler {
//
//    private final ButtonsHandler buttonsHandler;
//
//    public void handleCallbackQuery(CallbackQuery callbackQuery) {
//        String callbackData = callbackQuery.getData();
//        long chatId = callbackQuery.getMessage().getChatId();
//
//        buttonsHandler.botAnswerUtils(callbackData, chatId);
//    }
//
//}
