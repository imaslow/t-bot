package com.example.demo.service;

import com.example.demo.handle.HandleData;
import com.example.demo.model.Travel;
import com.example.demo.repository.TravelRepository;
import com.example.demo.service.interfaces.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final HandleData handleData;

    @Override
    public void getTravelPhrases(long chatId, String travelIdentifier, String message) {
        List<Travel> travelList = travelRepository.findTravelByTravelIdentifier(travelIdentifier);
        handleData.handleDataCommand(chatId, travelList, message);
    }
}
