package com.example.demo.comands;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
            new BotCommand("/start", "get a welcome message"),
            new BotCommand("/schedule", "get your schedule"),
            new BotCommand("/setdata", "set my data"),
            new BotCommand("/mydata", "get data in school"),
            new BotCommand("/contacts", "school contacts"),
            new BotCommand("/info", "info about school"),
            new BotCommand("/help", "info how to use this bot")
    );
}
