package com.example.demo.service;

import com.example.demo.buttons.*;
import com.example.demo.enums.ButtonName;
import com.example.demo.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.example.demo.util.BotConstants.*;
import static com.example.demo.util.TextConstants.*;

@Component
@RequiredArgsConstructor
public class ButtonsServiceImpl implements ButtonsService {

    private final SendBotMessageService sendBotMessageService;
    private final VerbsService verbsService;
    private final PersonalPronounsService personalPronounsService;
    private final PossessivePronounsService possessivePronounsService;
    private final ReflexivePronounsService reflexivePronounsService;
    private final StudentService studentService;

    @Override
    public void botAnswer(CallbackQuery callbackQuery) {
        ButtonName buttonName = ButtonName.valueOf(callbackQuery.getData());
        long chatId = callbackQuery.getMessage().getChatId();

        switch (buttonName) {
            case NO_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, NO_BUTTON_MESSAGE);
            case PRESENT_SIMPLE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_SIMPLE);
            case PAST_SIMPLE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PAST_SIMPLE);
            case FUTURE_SIMPLE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_SIMPLE);
            case PRESENT_CONTINUOUS_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_CONTINUOUS);
            case PAST_CONTINUOUS_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PAST_CONTINUOUS);
            case FUTURE_CONTINUOUS_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_CONTINUOUS);
            case PRESENT_PERFECT_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_PERFECT);
            case PAST_PERFECT_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, PAST_PERFECT);
            case FUTURE_PERFECT_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_PERFECT);
            case PRESENT_TO_BE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_PRESENT);
            case PAST_TO_BE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_PAST);
            case FUTURE_TO_BE_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_FUTURE);
            case TENSES_BUTTON -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
            case SIMPLE_BUTTON -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_SIMPLE_TENSES, ButtonsSimpleTenses.inlineMarkup());
            case CONTINUOUS_BUTTON -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_CONTINUOUS_TENSES, ButtonsContinuousTenses.inlineMarkup());
            case PERFECT_BUTTON -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_PERFECT_TENSES, ButtonsPerfectTenses.inlineMarkup());
            case VERBS_100 -> verbsService.handleVerbsDataCommand(chatId);
            case RETURN_CHOOSE_STUDY -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
            case RETURN_CHOOSE_TENSES -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
            case NO_BUTTON_DELETE_DATA -> sendBotMessageService.prepareAndSendMessage(chatId, NO_DELETE_MESSAGE);
            case YES_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, YES_BUTTON_MESSAGE);
                sendBotMessageService.sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
            }
            case PRONOUNS -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE);
                sendBotMessageService.sendButtonMessage(chatId, BUTTON_CHOOSE_PRONOUNS, ButtonsPronouns.inlineMarkup());
            }
            case PERSONAL_PRONOUNS_BUTTON -> {
                personalPronounsService.handlePersonalPronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_TWO);
            }
            case POSSESSIVE_PRONOUNS_BUTTON -> {
                possessivePronounsService.handlePossessivePronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_THREE);
            }
            case REFLEXIVE_PRONOUNS_BUTTON -> {
                reflexivePronounsService.handleReflexivePronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_FOUR);
            }
            case TO_BE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_DESCRIPTION);
                sendBotMessageService.sendButtonMessage(chatId, BUTTON_TO_BE, ButtonsToBe.inlineMarkup());
            }
            case YES_BUTTON_DELETE_DATA -> {
                studentService.deleteStudent(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, STUDENT_DELETE_MESSAGE);
            }
            case MODAL_VERBS -> {
                sendBotMessageService.prepareAndSendMessage(chatId, MODAL_VERBS_TEXT);
                sendBotMessageService.prepareAndSendMessage(chatId, MODAL_VERBS_TEXT2);
            }
        }
    }
}
