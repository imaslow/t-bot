package com.example.demo.service;

import com.example.demo.buttons.*;
import com.example.demo.config.BotConfig;
import com.example.demo.model.Schedule;
import com.example.demo.model.Student;
import com.example.demo.registr.RegisterUser;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.demo.comands.BotCommands.LIST_OF_COMMANDS;
import static com.example.demo.util.BotConstants.*;
import static com.example.demo.util.ButtonsConstants.*;
import static com.example.demo.util.TextConstants.*;

import java.util.List;

@Service
@Slf4j
public class TelegramBotService extends TelegramLongPollingBot {

    private final UserRepository userRepository;

    private final ScheduleRepository scheduleRepository;

    private final StudentRepository studentRepository;

    private final RegisterUser registerUser;

    private final BotConfig botConfig;

    public TelegramBotService(BotConfig botConfig, UserRepository userRepository, ScheduleRepository scheduleRepository,
                              StudentRepository studentRepository, RegisterUser registerUser) {
        this.botConfig = botConfig;
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
        this.studentRepository = studentRepository;
        this.registerUser = registerUser;
        initializeBotCommands();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleMessageUpdate(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            handleCallbackQuery(update.getCallbackQuery());
        }
    }

    private void handleMessageUpdate(Message message) {
        String text = message.getText();
        long chatId = message.getChatId();

        if (text.contains(SEND) && botConfig.getOwner() == chatId) {
            sendTextToAllUsers(text.substring(text.indexOf(" ")));
        } else {
            switch (text) {
                case START:
                    handleStartMessage(message);
                    break;
                case HELP:
                    prepareAndSendMessage(chatId, HELP_TEXT);
                    break;
                case CONTACTS:
                    prepareAndSendMessage(chatId, CONTACTS_MESSAGE);
                    break;
                case INFO:
                    prepareAndSendMessage(chatId, INFO_MESSAGE);
                    break;
                case SCHEDULE:
                    handleUserScheduleCommand(chatId);
                    break;
                case MY_DATA:
                    handleUserDataCommand(chatId);
                    break;
                default:
                    prepareAndSendMessage(chatId, "Sorry command not available");
            }
        }
    }

    private void botAnswerUtils(String receivedMessage, long chatId) {
        switch (receivedMessage) {
            case YES_BUTTON:
                prepareAndSendMessage(chatId, YES_BUTTON_MESSAGE);
                sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
                break;
            case NO_BUTTON:
                prepareAndSendMessage(chatId, NO_BUTTON_MESSAGE);
                break;
            case PRESENT_SIMPLE_BUTTON:
                prepareAndSendMessage(chatId, PRESENT_SIMPLE);
                break;
            case PAST_SIMPLE_BUTTON:
                prepareAndSendMessage(chatId, PAST_SIMPLE);
                break;
            case FUTURE_SIMPLE_BUTTON:
                prepareAndSendMessage(chatId, FUTURE_SIMPLE);
                break;
            case PRESENT_TO_BE_BUTTON:
                prepareAndSendMessage(chatId, TO_BE_PRESENT);
                break;
            case PAST_TO_BE_BUTTON:
                prepareAndSendMessage(chatId, TO_BE_PAST);
                break;
            case FUTURE_TO_BE_BUTTON:
                prepareAndSendMessage(chatId, TO_BE_FUTURE);
                break;
            case TENSES_BUTTON:
                sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
                break;
            case TO_BE_BUTTON:
                prepareAndSendMessage(chatId, TO_BE_DESCRIPTION);
                sendButtonMessage(chatId, BUTTON_TO_BE, ButtonsToBe.inlineMarkup());
                break;
            case SIMPLE_BUTTON:
                sendButtonMessage(chatId, BUTTON_SIMPLE_TENSES, ButtonsSimpleTenses.inlineMarkup());
                break;
            default:
                break;
        }
    }

    private void sendButtonMessage(long chatId, String text, InlineKeyboardMarkup replyMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setReplyMarkup(replyMarkup);

        executeMessage(message);
    }

    private void welcomeAndSendMessage(long chatId, String name) {

        String answer = "Hi, " + name + ", nice to meet you";
        log.info("Replied to user " + name);
        prepareAndSendMessage(chatId, answer);

    }

    private void prepareAndSendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        executeMessage(message);
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error(ERROR_TEXT + e.getMessage());
        }
    }

    private void initializeBotCommands() {
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error setting bot's command list: " + e.getMessage());
        }
    }

    private void handleStartMessage(Message message) {
        registerUser.register(message);
        welcomeAndSendMessage(message.getChatId(), message.getChat().getFirstName());
        sendButtonMessage(message.getChatId(), BUTTON_START_MESSAGE, ButtonsStartMessage.inlineMarkup());
    }

    private void sendTextToAllUsers(String textToSend) {
        userRepository.findAll().forEach(user -> prepareAndSendMessage(user.getChatId(), textToSend));
    }

    private void handleCallbackQuery(CallbackQuery callbackQuery) {
        String callbackData = callbackQuery.getData();
        long chatId = callbackQuery.getMessage().getChatId();

        botAnswerUtils(callbackData, chatId);
    }

    private void handleUserScheduleCommand(long chatId) {
        List<Schedule> schedules = scheduleRepository.findAll();
        StringBuilder scheduleMessage = new StringBuilder();
        scheduleMessage.append("Занятия в этом месяце:\n");
        for (Schedule schedule : schedules) {
            scheduleMessage.append(schedule.toString()).append("\n");
        }
        prepareAndSendMessage(chatId, scheduleMessage.toString());
    }

    private void handleUserDataCommand(long chatId) {
        List<Student> students = studentRepository.findAll();
        StringBuilder studentMessage = new StringBuilder();
        studentMessage.append("Данные студента:\n");

        for (Student student : students) {
            if (student.getUserChatId().getChatId().equals(chatId)) {
                studentMessage.append(student).append("\n");
                prepareAndSendMessage(chatId, studentMessage.toString());
                break;
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}

