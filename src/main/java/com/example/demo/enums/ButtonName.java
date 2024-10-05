package com.example.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ButtonName {

    YES_BUTTON("YES_BUTTON"),
    NO_BUTTON("NO_BUTTON"),
    YES_BUTTON_DELETE_DATA("YES_BUTTON_DELETE_DATA"),
    NO_BUTTON_DELETE_DATA("NO_BUTTON_DELETE_DATA"),
    PRESENT_SIMPLE_BUTTON("PRESENT_SIMPLE_BUTTON"),
    PAST_SIMPLE_BUTTON("PAST_SIMPLE_BUTTON"),
    FUTURE_SIMPLE_BUTTON("FUTURE_SIMPLE_BUTTON"),
    PRESENT_CONTINUOUS_BUTTON("PRESENT_CONTINUOUS_BUTTON"),
    PAST_CONTINUOUS_BUTTON("PAST_CONTINUOUS_BUTTON"),
    FUTURE_CONTINUOUS_BUTTON("FUTURE_CONTINUOUS_BUTTON"),
    PRESENT_PERFECT_BUTTON("PRESENT_PERFECT_BUTTON"),
    PAST_PERFECT_BUTTON("PAST_PERFECT_BUTTON"),
    FUTURE_PERFECT_BUTTON("FUTURE_PERFECT_BUTTON"),
    PRESENT_TO_BE_BUTTON("PRESENT_TO_BE_BUTTON"),
    PAST_TO_BE_BUTTON("PAST_TO_BE_BUTTON"),
    FUTURE_TO_BE_BUTTON("FUTURE_TO_BE_BUTTON"),
    TENSES_BUTTON("TENSES_BUTTON"),
    TO_BE_BUTTON("TO_BE_BUTTON"),
    SIMPLE_BUTTON("SIMPLE_BUTTON"),
    CONTINUOUS_BUTTON("CONTINUOUS_BUTTON"),
    PERFECT_BUTTON("PERFECT_BUTTON"),
    VERBS_100("VERBS_100"),
    PRONOUNS("PRONOUNS"),
    PERSONAL_PRONOUNS_BUTTON("PERSONAL_PRONOUNS_BUTTON"),
    POSSESSIVE_PRONOUNS_BUTTON("POSSESSIVE_PRONOUNS_BUTTON"),
    REFLEXIVE_PRONOUNS_BUTTON("REFLEXIVE_PRONOUNS_BUTTON"),
    RETURN_CHOOSE_STUDY("RETURN_CHOOSE_STUDY"),
    RETURN_CHOOSE_TENSES("RETURN_CHOOSE_TENSES"),
    MODAL_VERBS("MODAL_VERBS"),
    TRAVEL("TRAVEL"),
    CAR_BUTTON("CAR_BUTTON"),
    AIRLINE_BUTTON("AIRLINE_BUTTON"),
    TAXI_BUTTON("TAXI_BUTTON"),
    CUSTOM_BUTTON("CUSTOM_BUTTON"),
    RETURN_CHOOSE_TRAVEL("RETURN_CHOOSE_TRAVEL"),
    HOTEL_BUTTON("HOTEL_BUTTON"),
    RETURN_CHOOSE_SIMPLE_TENSES("RETURN_CHOOSE_SIMPLE_TENSES"),
    RETURN_CHOOSE_CONTINUOUS_TENSES("RETURN_CHOOSE_CONTINUOUS_TENSES"),
    RETURN_CHOOSE_PERFECT_TENSES("RETURN_CHOOSE_PERFECT_TENSES"),
    RETURN_CHOOSE_TO_BE("RETURN_CHOOSE_TO_BE"),
    RETURN_CHOOSE_PRONOUNS("RETURN_CHOOSE_PRONOUNS"),
    STREET_BUTTON("STREET_BUTTON"),
    CAFE_BUTTON("CAFE_BUTTON");

    private final String buttonName;
}
