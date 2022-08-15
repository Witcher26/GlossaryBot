package com.zvezdilin.TelegramBot.model.entity;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendVideo;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Glossary {
    public static void main(String[] args) {
        System.out.println("Telegram bot");

        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
        bot.setUpdatesListener(updates -> {
            updates.forEach(upd -> {
                try {
                    System.out.println(upd);
                    long chatId = upd.message().chat().id();
                    String incomeMessage = upd.message().text();


                    //logic
                    String result = "";
                    if (incomeMessage.equalsIgnoreCase("/start") | incomeMessage.equalsIgnoreCase("старт")) {
                        sendMessage(bot, chatId, "Welcome");
                    }
                    //send response

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private static void sendMessage(TelegramBot bot, long chatId, String message) {
        SendMessage request = new SendMessage(chatId, message);
        String[] buttons = new String[4];
        buttons[0] = "Добавить слово";
        buttons[1] = "Удалить слово";
        buttons[2] = "Вывести все";
        buttons[3] = "-";

        request.replyMarkup(new ReplyKeyboardMarkup(buttons));
        bot.execute(request);
    }

    private static void startEngine(String command) throws IOException {
        switch (command) {
            case "Вывести слово":
                String jsonString = Jsoup.connect("http://localhost:8080/api/engine/v1/startEngine")
                        .ignoreContentType(true)
                        .execute()
                        .body();
        }
    }
}


