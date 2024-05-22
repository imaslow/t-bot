//package com.example.demo.service;
//
//import com.example.demo.handle.MessageHandler;
//import com.example.demo.model.Schedule;
//import com.example.demo.repository.ScheduleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static com.example.demo.util.BotConstants.SCHEDULE_MESSAGE;
//
//@Service
//@RequiredArgsConstructor
//public class SchedulerService {
//
//    private final ScheduleRepository scheduleRepository;
//    private final MessageHandler messageHandler;
//
//    public void handleUserScheduleCommand(long chatId) {
//        List<Schedule> schedules = scheduleRepository.findAll();
//        StringBuilder scheduleMessage = new StringBuilder();
//        scheduleMessage.append(SCHEDULE_MESSAGE);
//        for (Schedule schedule : schedules) {
//            scheduleMessage.append(schedule.toString()).append("\n");
//        }
//        messageHandler.prepareAndSendMessage(chatId, scheduleMessage.toString());
//    }
//
//}
