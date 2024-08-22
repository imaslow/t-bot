package com.example.demo.buttons.returnbuttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ReturnChooseStudy {

    private static final InlineKeyboardButton RETURN_CHOOSE_STUDY = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        RETURN_CHOOSE_STUDY.setCallbackData("RETURN_CHOOSE_STUDY");

        List<InlineKeyboardButton> rowInline = List.of(RETURN_CHOOSE_STUDY);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
