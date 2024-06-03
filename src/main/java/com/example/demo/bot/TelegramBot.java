package com.example.demo.bot;

import com.example.demo.comands.CommandContainer;
import com.example.demo.comands.impl.SetDataCommandImpl;
import com.example.demo.config.properties.BotCredentialsProperties;
import com.example.demo.enums.BotState;
import com.example.demo.handle.ListMenu;
import com.example.demo.handle.UserState;
import com.example.demo.registr.RegisterUser;
import com.example.demo.service.interfaces.ButtonsService;
import com.example.demo.service.interfaces.SchedulerService;
import com.example.demo.service.interfaces.SendBotMessageService;
import com.example.demo.service.interfaces.StudentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;

import java.util.List;

import static com.example.demo.enums.CommandName.NO;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    private final BotCredentialsProperties botCredentialsProperties;
    private final ButtonsService buttonsService;

    private final CommandContainer commandContainer;
    private final SetDataCommandImpl setData;
    private final UserState userState;

    @SneakyThrows
    @Autowired
    public TelegramBot(RegisterUser registerUser,
                       BotCredentialsProperties botCredentialsProperties,
                       SchedulerService schedulerService,
                       ButtonsService buttonsService,
                       SendBotMessageService sendBotMessageService,
                       StudentService studentService,
                       UserState userState,
                       SetDataCommandImpl setData,
                       ListMenu listMenu) {
        this.buttonsService = buttonsService;
        this.setData = setData;
        this.userState = userState;
        this.botCredentialsProperties = botCredentialsProperties;
        List<BotCommand> listOfCommands = listMenu.getListOfCommands();
        this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        this.commandContainer = new CommandContainer(sendBotMessageService,
                registerUser, schedulerService, studentService, userState);
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String message = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();
            BotState state = userState.getUserState(chatId);
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                switch (state) {
                    case WAITING_FOR_FIRST_NAME -> setData.processFirstName(chatId, update);
                    case WAITING_FOR_LAST_NAME -> setData.processLastName(chatId, update);
                    case WAITING_FOR_EMAIL -> setData.processEmail(chatId, update);
                    default -> commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
                }
            }
        } else if (update.hasCallbackQuery()) {
            buttonsService.botAnswer(update.getCallbackQuery());
        }
    }

    @Override
    public String getBotUsername() {
        return botCredentialsProperties.getName();
    }

    @Override
    public String getBotToken() {
        return botCredentialsProperties.getToken();
    }
}

