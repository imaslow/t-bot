package com.example.demo.handle;

import com.example.demo.service.interfaces.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HandleData {

    private final SendBotMessageService sendBotMessageService;

    public <T> void handleDataCommand(long chatId, List<T> dataList, String messageHeader) {
        String dataMessage = dataList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n", messageHeader, ""));
        sendBotMessageService.prepareAndSendMessage(chatId, dataMessage);
    }

}
