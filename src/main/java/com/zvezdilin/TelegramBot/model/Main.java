package com.zvezdilin.TelegramBot.model;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Telegram bot");

        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
        bot.setUpdatesListener(updates -> {
            updates.forEach(upd -> {
                System.out.println(upd);
                long chatId = upd.message().chat().id();
                String incomeMessage = upd.message().text();
                String userName = upd.message().from().username();
                String message = "Hello " + userName;
                SendMessage request = new SendMessage(chatId, message);
                bot.execute(request);
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
