package com.example.demo.service;

import com.example.demo.buttons.*;
import com.example.demo.config.BotConfig;
import com.example.demo.model.*;
import com.example.demo.registr.RegisterUser;
import com.example.demo.repository.*;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TelegramBotService extends TelegramLongPollingBot {

    private final UserRepository userRepository;

    private final ScheduleRepository scheduleRepository;

    private final StudentRepository studentRepository;

    private final VerbsRepository verbsRepository;

    private final PersonalPronounsRepository personalPronounsRepository;

    private final PossessivePronounsRepository possessivePronounsRepository;

    private final ReflexivePronounsRepository reflexivePronounsRepository;

    private final RegisterUser registerUser;

    private final BotConfig botConfig;

    private final StudentService studentService;

    public TelegramBotService(UserRepository userRepository, ScheduleRepository scheduleRepository,
                              StudentRepository studentRepository, VerbsRepository verbsRepository,
                              PersonalPronounsRepository personalPronounsRepository,
                              PossessivePronounsRepository possessivePronounsRepository,
                              ReflexivePronounsRepository reflexivePronounsRepository,
                              RegisterUser registerUser, BotConfig botConfig,
                              StudentService studentService) {
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
        this.studentRepository = studentRepository;
        this.verbsRepository = verbsRepository;
        this.personalPronounsRepository = personalPronounsRepository;
        this.possessivePronounsRepository = possessivePronounsRepository;
        this.reflexivePronounsRepository = reflexivePronounsRepository;
        this.registerUser = registerUser;
        this.botConfig = botConfig;
        this.studentService = studentService;
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
                case SET_DATA:
                        prepareAndSendMessage(chatId, SET_DATA_FIRST_NAME); // Запрос на ввод имени
                        handleStudentSetData(chatId, message); // Обработка данных студента
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
            case PRESENT_CONTINUOUS_BUTTON:
                prepareAndSendMessage(chatId, PRESENT_CONTINUOUS);
                break;
            case PAST_CONTINUOUS_BUTTON:
                prepareAndSendMessage(chatId, PAST_CONTINUOUS);
                break;
            case FUTURE_CONTINUOUS_BUTTON:
                prepareAndSendMessage(chatId, FUTURE_CONTINUOUS);
                break;
            case PRESENT_PERFECT_BUTTON:
                prepareAndSendMessage(chatId, PRESENT_PERFECT);
                break;
            case PAST_PERFECT_BUTTON:
                prepareAndSendMessage(chatId, PAST_PERFECT);
                break;
            case FUTURE_PERFECT_BUTTON:
                prepareAndSendMessage(chatId, FUTURE_PERFECT);
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
            case CONTINUOUS_BUTTON:
                sendButtonMessage(chatId, BUTTON_CONTINUOUS_TENSES, ButtonsContinuousTenses.inlineMarkup());
                break;
            case PERFECT_BUTTON:
                sendButtonMessage(chatId, BUTTON_PERFECT_TENSES, ButtonsPerfectTenses.inlineMarkup());
                break;
            case VERBS_100:
                handleVerbsDataCommand(chatId);
                break;
            case PRONOUNS:
                prepareAndSendMessage(chatId, PRONOUNS_MESSAGE);
                sendButtonMessage(chatId, BUTTON_CHOOSE_PRONOUNS, ButtonsPronouns.inlineMarkup());
                break;
            case PERSONAL_PRONOUNS_BUTTON:
                handlePersonalPronounsCommand(chatId);
                prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_TWO);
                break;
            case POSSESSIVE_PRONOUNS_BUTTON:
                handlePossessivePronounsCommand(chatId);
                prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_THREE);
                break;
            case REFLEXIVE_PRONOUNS_BUTTON:
                handleReflexivePronounsCommand(chatId);
                prepareAndSendMessage(chatId, PRONOUNS_MESSAGE_FOUR);
                break;
            case RETURN_CHOOSE_STUDY:
                sendButtonMessage(chatId, BUTTON_CHOOSE_STUDY, ButtonsChooseStudy.inlineMarkup());
                break;
            case RETURN_CHOOSE_TENSES:
                sendButtonMessage(chatId, BUTTON_TENSES, ButtonsTenses.inlineMarkup());
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

    private void handleUserDataCommand(long chatId) {
        Optional<Student> studentOptional = studentRepository.findUserByChatId(chatId);

        studentOptional.ifPresentOrElse(
                student -> {
                    StringBuilder studentMessage = new StringBuilder();
                    studentMessage.append(STUDENT_MESSAGE);
                    studentMessage.append(student).append("\n");
                    prepareAndSendMessage(chatId, studentMessage.toString());
                },
                () -> prepareAndSendMessage(chatId, NOT_FOUND_STUDENT)
        );
    }

    private void handleUserScheduleCommand(long chatId) {
        List<Schedule> schedules = scheduleRepository.findAll();
        handleDataCommand(chatId, schedules, SCHEDULE_MESSAGE);
    }

    private void handlePersonalPronounsCommand(long chatId) {
        List<PersonalPronouns> personalPronounsList = personalPronounsRepository.findAll();
        handleDataCommand(chatId, personalPronounsList, PERSONAL_PRONOUNS_MESSAGE);
    }

    private void handlePossessivePronounsCommand(long chatId) {
        List<PossessivePronouns> possessivePronounsList = possessivePronounsRepository.findAll();
        handleDataCommand(chatId, possessivePronounsList, POSSESSIVE_PRONOUNS_MESSAGE);
    }

    private void handleReflexivePronounsCommand(long chatId) {
        List<ReflexivePronouns> reflexivePronounsList = reflexivePronounsRepository.findAll();
        handleDataCommand(chatId, reflexivePronounsList, REFLEXIVE_PRONOUNS_MESSAGE);
    }

    private void handleVerbsDataCommand(long chatId) {
        List<Verbs> verbs = verbsRepository.findAll();
        handleDataCommand(chatId, verbs, VERBS_MESSAGE);
    }

    private <T> void handleDataCommand(long chatId, List<T> dataList, String messageHeader) {
        String dataMessage = dataList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n", messageHeader, ""));
        prepareAndSendMessage(chatId, dataMessage);
    }

    public void handleStudentSetData(long chatId, Message message) {
        Student student = studentService.getStudent(chatId);
        if (student == null) {

            Student newStudent = new Student();
            newStudent.setChatId(message.getChatId());

            if (newStudent.getFirstName() == null) {
                newStudent.setFirstName(message.getText());
                studentService.saveOrUpdateUserData(newStudent);
                prepareAndSendMessage(newStudent.getChatId(), "Введите фамилию:");
            } else if (newStudent.getLastName() == null) {
                newStudent.setLastName(message.getText());
                studentService.saveOrUpdateUserData(newStudent);
                prepareAndSendMessage(newStudent.getChatId(), "Введите email:");
            } else if (newStudent.getEmail() == null) {
                newStudent.setEmail(message.getText());
                studentService.saveOrUpdateUserData(newStudent);
                prepareAndSendMessage(newStudent.getChatId(), "Данные успешно сохранены!");
            }
        }
    }
//        for (Student student : students) {
//            if (student.getChatId() != chatId) {
//                student.setChatId(chatId);
//                if (student.getFirstName() == null) {
//                    student.setFirstName(sendMessage);
//                    prepareAndSendMessage(chatId, "Введите фамилию:");
//                } else if (student.getLastName() == null) {
//                    student.setLastName(sendMessage);
//                    prepareAndSendMessage(chatId, "Введите email:");
//                } else if (student.getEmail() == null) {
//                    student.setEmail(sendMessage);
//                    studentService.saveOrUpdateUserData(student);
//                    prepareAndSendMessage(chatId, "Данные успешно сохранены!");
//                }
//            }
//        }


    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}

