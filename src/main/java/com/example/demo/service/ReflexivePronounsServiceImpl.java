package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.ReflexivePronouns;
import com.example.demo.repository.ReflexivePronounsRepository;
import com.example.demo.service.interfaces.ReflexivePronounsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.TextConstants.REFLEXIVE_PRONOUNS_MESSAGE;

@Service
@RequiredArgsConstructor
public class ReflexivePronounsServiceImpl implements ReflexivePronounsService {

    private final ReflexivePronounsRepository reflexivePronounsRepository;
    private final HandleData handleData;


    @Override
    public void handleReflexivePronounsCommand(long chatId) {
        List<ReflexivePronouns> reflexivePronounsList = reflexivePronounsRepository.findAll();
        handleData.handleDataCommand(chatId, reflexivePronounsList, REFLEXIVE_PRONOUNS_MESSAGE);
    }
}
