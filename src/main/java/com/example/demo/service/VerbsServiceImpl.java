package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.Verbs;
import com.example.demo.repository.VerbsRepository;
import com.example.demo.service.interfaces.VerbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.BotConstants.VERBS_MESSAGE;

@Service
@RequiredArgsConstructor
public class VerbsServiceImpl implements VerbsService {

    private final VerbsRepository verbsRepository;
    private final HandleData handleData;

    @Override
    public void handleVerbsDataCommand(long chatId) {
        List<Verbs> verbs = verbsRepository.findAll();
        handleData.handleDataCommand(chatId, verbs, VERBS_MESSAGE);
    }
}
