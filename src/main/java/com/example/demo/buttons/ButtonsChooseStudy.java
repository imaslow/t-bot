package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsChooseStudy {

    private static final InlineKeyboardButton TENSES_BUTTON = new InlineKeyboardButton("Tenses");
    private static final InlineKeyboardButton TO_BE_BUTTON = new InlineKeyboardButton("To be");
    private static final InlineKeyboardButton VERBS_100 = new InlineKeyboardButton("100 verbs");
    private static final InlineKeyboardButton PRONOUNS = new InlineKeyboardButton("Pronouns");
    public static final InlineKeyboardButton MODAL_VERBS = new InlineKeyboardButton("Modal verbs");

    public static InlineKeyboardMarkup inlineMarkup() {
        TENSES_BUTTON.setCallbackData("TENSES_BUTTON");
        TO_BE_BUTTON.setCallbackData("TO_BE_BUTTON");
        VERBS_100.setCallbackData("VERBS_100");
        PRONOUNS.setCallbackData("PRONOUNS");
        MODAL_VERBS.setCallbackData("MODAL_VERBS");

        List<InlineKeyboardButton> rowInline1 = List.of(TENSES_BUTTON, TO_BE_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(VERBS_100, PRONOUNS);
        List<InlineKeyboardButton> rowInline3 = List.of(MODAL_VERBS);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
