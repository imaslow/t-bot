package com.example.demo.handle;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ListMenu {

    private final List<BotCommand> listOfCommands;

    public ListMenu() {

        this.listOfCommands = new ArrayList<>();
        this.listOfCommands.add(new BotCommand("/start", "get a welcome message"));
        this.listOfCommands.add(new BotCommand("/schedule", "get the schedule for this month"));
        this.listOfCommands.add(new BotCommand("/setdata", "set your data in app"));
        this.listOfCommands.add(new BotCommand("/mydata", "get your data stored"));
        this.listOfCommands.add(new BotCommand("/deletedata", "delete my data"));
        this.listOfCommands.add(new BotCommand("/contacts", "get school contacts"));
        this.listOfCommands.add(new BotCommand("/info", "info about school"));
        this.listOfCommands.add(new BotCommand("/help", "info how to use this bot"));

    }

}
