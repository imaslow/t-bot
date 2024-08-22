package com.example.demo.buttons.returnbuttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ReturnChooseToBe {

    private static final InlineKeyboardButton RETURN_CHOOSE_TO_BE = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        RETURN_CHOOSE_TO_BE.setCallbackData("RETURN_CHOOSE_TO_BE");

        List<InlineKeyboardButton> rowInline = List.of(RETURN_CHOOSE_TO_BE);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
