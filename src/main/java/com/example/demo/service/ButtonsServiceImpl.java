package com.example.demo.service;

import com.example.demo.buttons.*;
import com.example.demo.buttons.returnbuttons.*;
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
    private final TravelService travelService;

    @Override
    public void botAnswer(CallbackQuery callbackQuery) {
        ButtonName buttonName = ButtonName.valueOf(callbackQuery.getData());
        long chatId = callbackQuery.getMessage().getChatId();

        switch (buttonName) {
            case NO_BUTTON -> sendBotMessageService.prepareAndSendMessage(chatId, NO_BUTTON_MESSAGE);
            case TENSES_BUTTON, RETURN_CHOOSE_TENSES -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
            case SIMPLE_BUTTON, RETURN_CHOOSE_SIMPLE_TENSES -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_SIMPLE_TENSES, ButtonsSimpleTenses.inlineMarkup());
            case CONTINUOUS_BUTTON, RETURN_CHOOSE_CONTINUOUS_TENSES -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_CONTINUOUS_TENSES, ButtonsContinuousTenses.inlineMarkup());
            case PERFECT_BUTTON, RETURN_CHOOSE_PERFECT_TENSES -> sendBotMessageService.sendButtonMessage(chatId, BUTTON_PERFECT_TENSES, ButtonsPerfectTenses.inlineMarkup());
            case NO_BUTTON_DELETE_DATA -> sendBotMessageService.prepareAndSendMessage(chatId, NO_DELETE_MESSAGE);
            case TRAVEL, RETURN_CHOOSE_TRAVEL -> sendBotMessageService.sendButtonMessage(chatId, TRAVEL_MESSAGE, ButtonsChooseTravel.inlineMarkup());
            case PRESENT_SIMPLE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_SIMPLE);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_SIMPLE_TENSES, ReturnChooseSimpleTenses.inlineMarkup());
            }
            case PAST_SIMPLE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PAST_SIMPLE);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_SIMPLE_TENSES, ReturnChooseSimpleTenses.inlineMarkup());
            }
            case FUTURE_SIMPLE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_SIMPLE);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_SIMPLE_TENSES, ReturnChooseSimpleTenses.inlineMarkup());
            }
            case PRESENT_CONTINUOUS_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_CONTINUOUS);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CONTINUOUS_TENSES, ReturnChooseContinuosTenses.inlineMarkup());
            }
            case PAST_CONTINUOUS_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PAST_CONTINUOUS);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CONTINUOUS_TENSES, ReturnChooseContinuosTenses.inlineMarkup());
            }
            case FUTURE_CONTINUOUS_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_CONTINUOUS);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CONTINUOUS_TENSES, ReturnChooseContinuosTenses.inlineMarkup());
            }
            case PRESENT_PERFECT_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PRESENT_PERFECT);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_PERFECT_TENSES, ReturnChoosePerfectTenses.inlineMarkup());
            }
            case PAST_PERFECT_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PAST_PERFECT);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_PERFECT_TENSES, ReturnChoosePerfectTenses.inlineMarkup());
            }
            case FUTURE_PERFECT_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, FUTURE_PERFECT);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_PERFECT_TENSES, ReturnChoosePerfectTenses.inlineMarkup());
            }
            case PRESENT_TO_BE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_PRESENT);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_TO_BE, ReturnChooseToBe.inlineMarkup());
            }
            case PAST_TO_BE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_PAST);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_TO_BE, ReturnChooseToBe.inlineMarkup());
            }
            case FUTURE_TO_BE_BUTTON -> {
                sendBotMessageService.prepareAndSendMessage(chatId, TO_BE_FUTURE);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_TO_BE, ReturnChooseToBe.inlineMarkup());
            }
            case VERBS_100 -> {
                verbsService.handleVerbsDataCommand(chatId);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_STUDY, ReturnChooseStudy.inlineMarkup());
            }
            case CAR_BUTTON -> {
                travelService.getTravelPhrases(chatId, CAR_TRAVEL, CAR_TRAVEL_PHRASES);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_TRAVEL_MESSAGE, ReturnChooseTravelButton.inlineMarkup());
            }
            case TAXI_BUTTON -> {
                travelService.getTravelPhrases(chatId, TAXI_TRAVEL, TAXI_TRAVEL_PHRASES);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_TRAVEL_MESSAGE, ReturnChooseTravelButton.inlineMarkup());
            }
            case CUSTOM_BUTTON -> {
                travelService.getTravelPhrases(chatId, CUSTOM_TRAVEL, CUSTOM_TRAVEL_PHRASES);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_TRAVEL_MESSAGE, ReturnChooseTravelButton.inlineMarkup());
            }
            case AIRLINE_BUTTON -> {
                travelService.getTravelPhrases(chatId, AIRLINE_TRAVEL, AIRLINE_TRAVEL_PHRASES);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_TRAVEL_MESSAGE, ReturnChooseTravelButton.inlineMarkup());
            }
            case HOTEL_BUTTON -> {
                travelService.getTravelPhrases(chatId, HOTEL_TRAVEL, HOTEL_TRAVEL_PHRASES);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_TRAVEL_MESSAGE, ReturnChooseTravelButton.inlineMarkup());
            }
            case YES_BUTTON, RETURN_CHOOSE_STUDY -> {
                sendBotMessageService.prepareAndSendMessage(chatId, YES_BUTTON_MESSAGE);
                sendBotMessageService.sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
            }
            case PRONOUNS, RETURN_CHOOSE_PRONOUNS -> {
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE);
                sendBotMessageService.sendButtonMessage(chatId, BUTTON_CHOOSE_PRONOUNS, ButtonsPronouns.inlineMarkup());
            }
            case PERSONAL_PRONOUNS_BUTTON -> {
                personalPronounsService.handlePersonalPronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_TWO);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_PRONOUNS, ReturnChoosePronouns.inlineMarkup());
            }
            case POSSESSIVE_PRONOUNS_BUTTON -> {
                possessivePronounsService.handlePossessivePronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_THREE);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_PRONOUNS, ReturnChoosePronouns.inlineMarkup());
            }
            case REFLEXIVE_PRONOUNS_BUTTON -> {
                reflexivePronounsService.handleReflexivePronounsCommand(chatId);
                sendBotMessageService.prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_FOUR);
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_PRONOUNS, ReturnChoosePronouns.inlineMarkup());
            }
            case TO_BE_BUTTON, RETURN_CHOOSE_TO_BE -> {
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
                sendBotMessageService.sendButtonMessage(chatId, RETURN_CHOOSE_STUDY, ReturnChooseStudy.inlineMarkup());
            }
        }
    }
}
