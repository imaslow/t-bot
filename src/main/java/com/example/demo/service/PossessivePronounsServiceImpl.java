package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.PossessivePronouns;
import com.example.demo.repository.PossessivePronounsRepository;
import com.example.demo.service.interfaces.PossessivePronounsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.TextConstants.POSSESSIVE_PRONOUNS_MESSAGE;

@Service
@RequiredArgsConstructor
public class PossessivePronounsServiceImpl implements PossessivePronounsService {

    private final PossessivePronounsRepository possessivePronounsRepository;
    private final HandleData handleData;

    @Override
    public void handlePossessivePronounsCommand(long chatId) {
        List<PossessivePronouns> possessivePronounsList = possessivePronounsRepository.findAll();
        handleData.handleDataCommand(chatId, possessivePronounsList, POSSESSIVE_PRONOUNS_MESSAGE);
    }
}
