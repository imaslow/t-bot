package com.example.demo.comands.interfaces;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);

}
