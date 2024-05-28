package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsPronouns {


    private static final InlineKeyboardButton PERSONAL_PRONOUNS_BUTTON = new InlineKeyboardButton("Personal");
    private static final InlineKeyboardButton POSSESSIVE_PRONOUNS_BUTTON = new InlineKeyboardButton("Possessive");
    private static final InlineKeyboardButton REFLEXIVE_PRONOUNS_BUTTON = new InlineKeyboardButton("Reflexive");
    private static final InlineKeyboardButton RETURN_CHOOSE_STUDY = new InlineKeyboardButton("<< Return");

    public static InlineKeyboardMarkup inlineMarkup() {
        PERSONAL_PRONOUNS_BUTTON.setCallbackData("PERSONAL_PRONOUNS_BUTTON");
        POSSESSIVE_PRONOUNS_BUTTON.setCallbackData("POSSESSIVE_PRONOUNS_BUTTON");
        REFLEXIVE_PRONOUNS_BUTTON.setCallbackData("REFLEXIVE_PRONOUNS_BUTTON");
        RETURN_CHOOSE_STUDY.setCallbackData("RETURN_CHOOSE_STUDY");

        List<InlineKeyboardButton> rowInline1 = List.of(PERSONAL_PRONOUNS_BUTTON, POSSESSIVE_PRONOUNS_BUTTON);
        List<InlineKeyboardButton> rowInline2 = List.of(REFLEXIVE_PRONOUNS_BUTTON);
        List<InlineKeyboardButton> rowInline3 = List.of(RETURN_CHOOSE_STUDY);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline1, rowInline2, rowInline3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
