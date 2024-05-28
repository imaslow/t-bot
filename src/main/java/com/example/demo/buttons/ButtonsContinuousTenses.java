package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsContinuousTenses {

    private static final InlineKeyboardButton PRESENT_CONTINUOUS_BUTTON = new InlineKeyboardButton("Present Continuous");
    private static final InlineKeyboardButton PAST_CONTINUOUS_BUTTON = new InlineKeyboardButton("Past Continuous");
    private static final InlineKeyboardButton FUTURE_CONTINUOUS_BUTTON = new InlineKeyboardButton("Future Continuous");
    private static final InlineKeyboardButton RETURN_CHOOSE_TENSES = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        PRESENT_CONTINUOUS_BUTTON.setCallbackData("PRESENT_CONTINUOUS_BUTTON");
        PAST_CONTINUOUS_BUTTON.setCallbackData("PAST_CONTINUOUS_BUTTON");
        FUTURE_CONTINUOUS_BUTTON.setCallbackData("FUTURE_CONTINUOUS_BUTTON");
        RETURN_CHOOSE_TENSES.setCallbackData("RETURN_CHOOSE_TENSES");

        List<InlineKeyboardButton> rowInline1 = List.of(PRESENT_CONTINUOUS_BUTTON, PAST_CONTINUOUS_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(FUTURE_CONTINUOUS_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(RETURN_CHOOSE_TENSES);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
