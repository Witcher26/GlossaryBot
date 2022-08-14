package com.zvezdilin.TelegramBot.model.entity;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

import java.time.LocalDateTime;

public class WakeUp {
    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
        //244747488-chatId
        int hourWakeUp = 14;
        int minutesWakeUp = 57;
        while (true) {
            Thread.sleep(1000 * 60);
            int hour = LocalDateTime.now().getHour();
            int minutes = LocalDateTime.now().getMinute();

            if (hour == hourWakeUp && minutes == minutesWakeUp) { //скорее всего &&
                SendMessage request = new SendMessage(244747488, "Wake UP");
                bot.execute(request);
            }
        }
    }
}
