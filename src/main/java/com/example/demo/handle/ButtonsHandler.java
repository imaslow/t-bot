//package com.example.demo.handle;
//
//import com.example.demo.buttons.ButtonsChooseStudy;
//import com.example.demo.buttons.ButtonsSimpleTenses;
//import com.example.demo.buttons.ButtonsTenses;
//import com.example.demo.buttons.ButtonsToBe;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
//import static com.example.demo.util.BotConstants.*;
//import static com.example.demo.util.ButtonsConstants.*;
//import static com.example.demo.util.TextConstants.*;
//
//@Component
//@RequiredArgsConstructor
//public class ButtonsHandler {
//
//    private final MessageHandler messageHandler;
//
//    public void botAnswerUtils(String receivedMessage, long chatId) {
//        switch (receivedMessage) {
//            case YES_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, YES_BUTTON_MESSAGE);
//                messageHandler.sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
//                break;
//            case NO_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, NO_BUTTON_MESSAGE);
//                break;
//            case PRESENT_SIMPLE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, PRESENT_SIMPLE);
//                break;
//            case PAST_SIMPLE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, PAST_SIMPLE);
//                break;
//            case FUTURE_SIMPLE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, FUTURE_SIMPLE);
//                break;
//            case PRESENT_TO_BE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, TO_BE_PRESENT);
//                break;
//            case PAST_TO_BE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, TO_BE_PAST);
//                break;
//            case FUTURE_TO_BE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, TO_BE_FUTURE);
//                break;
//            case TENSES_BUTTON:
//                messageHandler.sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
//                break;
//            case TO_BE_BUTTON:
//                messageHandler.prepareAndSendMessage(chatId, TO_BE_DESCRIPTION);
//                messageHandler.sendButtonMessage(chatId, BUTTON_TO_BE, ButtonsToBe.inlineMarkup());
//                break;
//            case SIMPLE_BUTTON:
//                messageHandler.sendButtonMessage(chatId, BUTTON_SIMPLE_TENSES, ButtonsSimpleTenses.inlineMarkup());
//                break;
//            default:
//                break;
//        }
//    }
//
//}
