package com.example.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandName {

    START("/start"),
    SCHEDULE("/schedule"),
    SET_DATA("/setdata"),
    MY_DATA("/mydata"),
    DELETE_DATA("/deletedata"),
    CONTACTS("/contacts"),
    INFO("/info"),
    NO("nocommand"),
    SEND("/send"),
    HELP("/help");

    private final String commandName;

}
