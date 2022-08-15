//package com.zvezdilin.TelegramBot.model.entity;
//
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.UpdatesListener;
//import com.pengrad.telegrambot.request.SendMessage;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
//public class JSoupExchangeRate {
//
//    public static void main(String[] args) throws IOException {
//        System.out.println("Telegram bot");
//
//        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
//        bot.setUpdatesListener(updates -> {
//            updates.forEach(upd -> {
//                try {
//                    System.out.println(upd);
//                    long chatId = upd.message().chat().id();
//                    String incomeMessage = upd.message().text();
//
//                    //logic
//                    var date = "09/08/2022";
//                    String result = "";
//                    Document doc = Jsoup.connect("https://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date).get();
//                    System.out.println(doc.title());
//                    Elements valutes = doc.select("Valute");
//                    for (Element valute : valutes) {
//                        if (valute.attr("ID").equals("R01235")) {
//                            result = valute.select("Value").text();
//                            System.out.println(result);
//                        }
//                    }
//                    //send response
//                    SendMessage request = new SendMessage(chatId, result);
//                    bot.execute(request);
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            });
//            return UpdatesListener.CONFIRMED_UPDATES_ALL;
//        });
//    }
//}
