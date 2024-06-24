package com.example.demo.comands;

import com.example.demo.comands.impl.*;
import com.example.demo.comands.interfaces.Command;
import com.example.demo.handle.UserState;
import com.example.demo.registr.RegisterUser;
import com.example.demo.service.interfaces.SchedulerService;
import com.example.demo.service.interfaces.SendBotMessageService;
import com.example.demo.service.interfaces.StudentService;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import static com.example.demo.enums.CommandName.*;

@Component
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService,
                            RegisterUser registerUser,
                            SchedulerService schedulerService,
                            StudentService studentService,
                            UserState userState) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommandImpl(sendBotMessageService, registerUser))
                .put(SCHEDULE.getCommandName(), new SchedulerCommandImpl(schedulerService))
                .put(MY_DATA.getCommandName(), new MyDataCommandImpl(studentService))
                .put(CONTACTS.getCommandName(), new ContactsCommandImpl(sendBotMessageService))
                .put(INFO.getCommandName(), new InfoCommandImpl(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommandImpl(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommandImpl(sendBotMessageService))
                .put(SEND.getCommandName(), new SendAllUsersCommandImpl(sendBotMessageService))
                .put(SET_DATA.getCommandName(), new SetDataCommandImpl(sendBotMessageService, studentService, userState))
                .put(DELETE_DATA.getCommandName(), new DeleteDataCommandImpl(studentService, sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommandImpl(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
