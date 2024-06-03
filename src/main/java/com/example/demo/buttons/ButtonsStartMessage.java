package com.example.demo.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonsStartMessage {
    private static final InlineKeyboardButton YES_BUTTON = new InlineKeyboardButton("Yes");
    private static final InlineKeyboardButton NO_BUTTON = new InlineKeyboardButton("No");

    public static InlineKeyboardMarkup inlineMarkup() {
        YES_BUTTON.setCallbackData("YES_BUTTON");
        NO_BUTTON.setCallbackData("NO_BUTTON");

        List<InlineKeyboardButton> rowInline = List.of(YES_BUTTON, NO_BUTTON);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
