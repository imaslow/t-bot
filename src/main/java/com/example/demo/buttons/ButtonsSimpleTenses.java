package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsSimpleTenses {

    private static final InlineKeyboardButton PRESENT_SIMPLE_BUTTON = new InlineKeyboardButton("Present Simple");
    private static final InlineKeyboardButton PAST_SIMPLE_BUTTON = new InlineKeyboardButton("Past Simple");
    private static final InlineKeyboardButton FUTURE_SIMPLE_BUTTON = new InlineKeyboardButton("Future Simple");
    private static final InlineKeyboardButton RETURN_CHOOSE_TENSES = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        PRESENT_SIMPLE_BUTTON.setCallbackData("PRESENT_SIMPLE_BUTTON");
        PAST_SIMPLE_BUTTON.setCallbackData("PAST_SIMPLE_BUTTON");
        FUTURE_SIMPLE_BUTTON.setCallbackData("FUTURE_SIMPLE_BUTTON");
        RETURN_CHOOSE_TENSES.setCallbackData("RETURN_CHOOSE_TENSES");

        List<InlineKeyboardButton> rowInline1 = List.of(PRESENT_SIMPLE_BUTTON, PAST_SIMPLE_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(FUTURE_SIMPLE_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(RETURN_CHOOSE_TENSES);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
