package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.interfaces.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.BotConstants.SCHEDULE_MESSAGE;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final ScheduleRepository scheduleRepository;
    private final HandleData handleData;

    @Override
    public void handleUserScheduleCommand(long chatId) {
        List<Schedule> schedules = scheduleRepository.findAll();
        handleData.handleDataCommand(chatId, schedules, SCHEDULE_MESSAGE);
    }

}
