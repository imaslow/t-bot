package com.example.demo.service.interfaces;

import com.example.demo.model.Travel;

public interface TravelService {

    void getTravelPhrases(long chatId, String travelIdentifier, String message);

}
