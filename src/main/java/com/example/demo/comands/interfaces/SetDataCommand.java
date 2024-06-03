package com.example.demo.comands.interfaces;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface SetDataCommand {

    void processFirstName(long chatId, Update update);

    void processLastName(long chatId, Update update);

    void processEmail(long chatId, Update update);

}
