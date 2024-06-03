package com.example.demo.comands.impl;

import com.example.demo.comands.interfaces.Command;
import com.example.demo.service.interfaces.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class SchedulerCommandImpl implements Command {

    private final SchedulerService schedulerService;

    @Override
    public void execute(Update update) {
        schedulerService.handleUserScheduleCommand(update.getMessage().getChatId());
    }
}
