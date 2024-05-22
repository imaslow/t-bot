package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsToBe {

    private static final InlineKeyboardButton PRESENT_TO_BE_BUTTON = new InlineKeyboardButton("Present");
    private static final InlineKeyboardButton PAST_TO_BE_BUTTON = new InlineKeyboardButton("Past");
    private static final InlineKeyboardButton FUTURE_TO_BE_BUTTON = new InlineKeyboardButton("Future");

    public static InlineKeyboardMarkup inlineMarkup() {
        PRESENT_TO_BE_BUTTON.setCallbackData("PRESENT_TO_BE_BUTTON");
        PAST_TO_BE_BUTTON.setCallbackData("PAST_TO_BE_BUTTON");
        FUTURE_TO_BE_BUTTON.setCallbackData("FUTURE_TO_BE_BUTTON");

        List<InlineKeyboardButton> rowInline1 = List.of(PRESENT_TO_BE_BUTTON, PAST_TO_BE_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(FUTURE_TO_BE_BUTTON);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
