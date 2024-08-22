package com.example.demo.buttons.returnbuttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ReturnChoosePronouns {

    private static final InlineKeyboardButton RETURN_CHOOSE_PRONOUNS = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        RETURN_CHOOSE_PRONOUNS.setCallbackData("RETURN_CHOOSE_PRONOUNS");

        List<InlineKeyboardButton> rowInline = List.of(RETURN_CHOOSE_PRONOUNS);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
