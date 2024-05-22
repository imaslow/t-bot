package com.example.demo.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@Component
public class ButtonsChooseStudy {

    private static final InlineKeyboardButton TENSES_BUTTON = new InlineKeyboardButton("Tenses");
    private static final InlineKeyboardButton TO_BE_BUTTON = new InlineKeyboardButton("To be");

    public static InlineKeyboardMarkup inlineMarkup() {
        TENSES_BUTTON.setCallbackData("TENSES_BUTTON");
        TO_BE_BUTTON.setCallbackData("TO_BE_BUTTON");

        List<InlineKeyboardButton> rowInline = List.of(TENSES_BUTTON, TO_BE_BUTTON);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
