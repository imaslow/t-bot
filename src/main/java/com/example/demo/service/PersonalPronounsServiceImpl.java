package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.PersonalPronouns;
import com.example.demo.repository.PersonalPronounsRepository;
import com.example.demo.service.interfaces.PersonalPronounsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.TextConstants.PERSONAL_PRONOUNS_MESSAGE;

@Service
@RequiredArgsConstructor
public class PersonalPronounsServiceImpl implements PersonalPronounsService {

    private final PersonalPronounsRepository personalPronounsRepository;
    private final HandleData handleData;

    @Override
    public void handlePersonalPronounsCommand(long chatId) {
        List<PersonalPronouns> personalPronounsList = personalPronounsRepository.findAll();
        handleData.handleDataCommand(chatId, personalPronounsList, PERSONAL_PRONOUNS_MESSAGE);
    }
}
