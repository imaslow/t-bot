package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsDeleteData {

    private static final InlineKeyboardButton YES_BUTTON_DELETE_DATA = new InlineKeyboardButton("Yes");
    private static final InlineKeyboardButton NO_BUTTON_DELETE_DATA = new InlineKeyboardButton("No");

    public static InlineKeyboardMarkup inlineMarkup() {
        YES_BUTTON_DELETE_DATA.setCallbackData("YES_BUTTON_DELETE_DATA");
        NO_BUTTON_DELETE_DATA.setCallbackData("NO_BUTTON_DELETE_DATA");

        List<InlineKeyboardButton> rowInline = List.of(YES_BUTTON_DELETE_DATA, NO_BUTTON_DELETE_DATA);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

}
