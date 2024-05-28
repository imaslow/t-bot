package com.example.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BotConstants {

    public static final String START = "/start";
    public static final String HELP = "/help";
    public static final String SEND = "/send";
    public static final String CONTACTS = "/contacts";
    public static final String INFO = "/info";
    public static final String SCHEDULE = "/schedule";
    public static final String MY_DATA = "/mydata";
    public static final String SET_DATA = "/setdata";
    public static final String ERROR_TEXT = "Error occurred: ";
    public static final String YES_BUTTON_MESSAGE = "You're already one step closer to your goal!";
    public static final String NO_BUTTON_MESSAGE = "Close the door on the other side";
    public static final String BUTTON_START_MESSAGE = "Do you really want to study?";
    public static final String BUTTON_SIMPLE_TENSES = "Choose Simple tenses";
    public static final String BUTTON_CONTINUOUS_TENSES = "Choose continuous tenses";
    public static final String BUTTON_PERFECT_TENSES = "Choose perfect tenses";
    public static final String BUTTON_CHOOSE_STUDY = "Choose what will learn today";
    public static final String BUTTON_CHOOSE_PRONOUNS = "Choose pronouns";
    public static final String BUTTON_TO_BE = "Choose tenses about be";
    public static final String BUTTON_TENSES = "Choose tenses";
    public static final String SCHEDULE_MESSAGE = "Занятия в этом месяце:\n";
    public static final String VERBS_MESSAGE = "This is 100 most popular verbs in 3 forms:\n\n";
    public static final String STUDENT_MESSAGE = "Данные студента:\n";
    public static final String NOT_FOUND_STUDENT = "Данные студента не найдены.";

    public static final String SET_DATA_FIRST_NAME = "Введите имя:";

}
