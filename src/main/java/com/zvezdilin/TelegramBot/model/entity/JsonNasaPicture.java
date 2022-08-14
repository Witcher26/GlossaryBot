package com.zvezdilin.TelegramBot.model.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import org.jsoup.Jsoup;

import java.io.IOException;

public class JsonNasaPicture {
    public static void main(String[] args) throws IOException {
        System.out.println("Telegram bot");

        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
        bot.setUpdatesListener(updates -> {
            updates.forEach(upd -> {
                try {
                    System.out.println(upd);
                    long chatId = upd.message().chat().id();
                    String incomeMessage = upd.message().text();
                    //logic
                    String data = incomeMessage;
                    String jsonString = Jsoup.connect("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + data)
                            .ignoreContentType(true)
                            .execute()
                            .body();
                    ObjectMapper objectMapper = new ObjectMapper();
                    var jsonNode = objectMapper.readTree(jsonString);
                    String imageUrl = jsonNode.get("url").asText();
                    String explanation = jsonNode.get("explanation").asText();
                    String result = imageUrl + "\n" + explanation;

                    //send response
                    SendMessage request = new SendMessage(chatId, result);
                    bot.execute(request);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
