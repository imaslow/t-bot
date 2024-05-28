package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsPerfectTenses {

    private static final InlineKeyboardButton PRESENT_PERFECT_BUTTON = new InlineKeyboardButton("Present Perfect");
    private static final InlineKeyboardButton PAST_PERFECT_BUTTON = new InlineKeyboardButton("Past Perfect");
    private static final InlineKeyboardButton FUTURE_PERFECT_BUTTON = new InlineKeyboardButton("Future Perfect");
    private static final InlineKeyboardButton RETURN_CHOOSE_TENSES = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        PRESENT_PERFECT_BUTTON.setCallbackData("PRESENT_PERFECT_BUTTON");
        PAST_PERFECT_BUTTON.setCallbackData("PAST_PERFECT_BUTTON");
        FUTURE_PERFECT_BUTTON.setCallbackData("FUTURE_PERFECT_BUTTON");
        RETURN_CHOOSE_TENSES.setCallbackData("RETURN_CHOOSE_TENSES");

        List<InlineKeyboardButton> rowInline1 = List.of(PRESENT_PERFECT_BUTTON, PAST_PERFECT_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(FUTURE_PERFECT_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(RETURN_CHOOSE_TENSES);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
