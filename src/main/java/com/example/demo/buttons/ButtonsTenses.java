package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsTenses {

    private static final InlineKeyboardButton SIMPLE_BUTTON = new InlineKeyboardButton("Simple");
    private static final InlineKeyboardButton CONTINUOUS_BUTTON = new InlineKeyboardButton("Continuous");
    private static final InlineKeyboardButton PERFECT_BUTTON = new InlineKeyboardButton("Perfect");
    private static final InlineKeyboardButton RETURN_CHOOSE_STUDY = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        SIMPLE_BUTTON.setCallbackData("SIMPLE_BUTTON");
        CONTINUOUS_BUTTON.setCallbackData("CONTINUOUS_BUTTON");
        PERFECT_BUTTON.setCallbackData("PERFECT_BUTTON");
        RETURN_CHOOSE_STUDY.setCallbackData("RETURN_CHOOSE_STUDY");

        List<InlineKeyboardButton> rowInline1 = List.of(SIMPLE_BUTTON, CONTINUOUS_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(PERFECT_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(RETURN_CHOOSE_STUDY);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
