package com.example.demo.handle;

import com.example.demo.enums.BotState;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserState {

    private static final ConcurrentHashMap<Long, BotState> userStates = new ConcurrentHashMap<>();

    public void setUserState(Long userId, BotState state) {
        userStates.put(userId, state);
    }

    public BotState getUserState(Long userId) {
        return userStates.getOrDefault(userId, BotState.NONE);
    }

    public void clearUserState(Long userId) {
        userStates.remove(userId);
    }
}
