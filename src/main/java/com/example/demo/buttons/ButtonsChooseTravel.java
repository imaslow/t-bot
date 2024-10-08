package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsChooseTravel {

    private static final InlineKeyboardButton CAR_BUTTON = new InlineKeyboardButton("Car");
    private static final InlineKeyboardButton AIRLINE_BUTTON = new InlineKeyboardButton("Airline");
    private static final InlineKeyboardButton TAXI_BUTTON = new InlineKeyboardButton("Taxi");
    private static final InlineKeyboardButton CUSTOM_BUTTON = new InlineKeyboardButton("Custom");
    private static final InlineKeyboardButton HOTEL_BUTTON = new InlineKeyboardButton("Hotel");
    private static final InlineKeyboardButton STREET_BUTTON = new InlineKeyboardButton("Street");
    private static final InlineKeyboardButton CAFE_BUTTON = new InlineKeyboardButton("Cafe");
    private static final InlineKeyboardButton RETURN_CHOOSE_STUDY = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        CAR_BUTTON.setCallbackData("CAR_BUTTON");
        AIRLINE_BUTTON.setCallbackData("AIRLINE_BUTTON");
        TAXI_BUTTON.setCallbackData("TAXI_BUTTON");
        CUSTOM_BUTTON.setCallbackData("CUSTOM_BUTTON");
        HOTEL_BUTTON.setCallbackData("HOTEL_BUTTON");
        STREET_BUTTON.setCallbackData("STREET_BUTTON");
        CAFE_BUTTON.setCallbackData("CAFE_BUTTON");
        RETURN_CHOOSE_STUDY.setCallbackData("RETURN_CHOOSE_STUDY");

        List<InlineKeyboardButton> rowInline1 = List.of(CAR_BUTTON, AIRLINE_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(TAXI_BUTTON, CUSTOM_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(STREET_BUTTON, CAFE_BUTTON);
        List<InlineKeyboardButton> rowInline4 = List.of(HOTEL_BUTTON, RETURN_CHOOSE_STUDY);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3, rowInline4);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
