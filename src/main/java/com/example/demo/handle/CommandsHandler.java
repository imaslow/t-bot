//package com.example.demo.handle;
//
//import com.example.demo.service.SchedulerService;
//import com.example.demo.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.api.objects.Message;
//
//import static com.example.demo.util.BotConstants.*;
//import static com.example.demo.util.TextConstants.*;
//
//@Component
//@RequiredArgsConstructor
//public class CommandsHandler {
//
//    private final MessageHandler messageHandler;
//    private final SchedulerService schedulerService;
//    private final UserService userService;
//
//    public void botMenuCommand(Message message) {
//        String text = message.getText();
//        long chatId = message.getChatId();
//
//        switch (text) {
//            case START:
//                messageHandler.handleStartMessage(message);
//                break;
//            case HELP:
//                messageHandler.prepareAndSendMessage(chatId, HELP_TEXT);
//                break;
//            case CONTACTS:
//                messageHandler.prepareAndSendMessage(chatId, CONTACTS_MESSAGE);
//                break;
//            case INFO:
//                messageHandler.prepareAndSendMessage(chatId, INFO_MESSAGE);
//                break;
//            case SCHEDULE:
//                schedulerService.handleUserScheduleCommand(chatId);
//                break;
//            case MY_DATA:
//                userService.handleUserDataCommand(chatId);
//                break;
//            default:
//                messageHandler.prepareAndSendMessage(chatId, "Sorry command not available");
//        }
//    }
//
//}
