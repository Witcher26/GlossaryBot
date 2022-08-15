//package com.zvezdilin.TelegramBot;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.UpdatesListener;
//import com.pengrad.telegrambot.request.SendMessage;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class MainNews {
//    public static void main(String[] args) {
//        System.out.println("Telegram bot");
//        TelegramBot bot = new TelegramBot("5586945414:AAGHN0R9ybKOhKQFr1oVEcPLklwyDYHddXc");
//
//        bot.setUpdatesListener(updates -> {
//            while (true) {
//                updates.forEach(upd -> {
//                    try {
//                        System.out.println(upd);
//                        long chatId = upd.message().chat().id();
//                        String incomeMessage = upd.message().text();
//                        //logic
//                        String result = "";
//                        if (incomeMessage.equals("/start")) {
//                            result = "Hello " + upd.message().from().username() + ". ¬ыбери категорию: 1 - курсы валют, 2 - новости";
//                        }
//
//                        if (incomeMessage.equals("1")) {
//                            Document doc = Jsoup.connect("https://www.cbr.ru/scripts/XML_daily.asp?date_req=" + incomeMessage).get();
//                            System.out.println(doc.title());
//                            Elements valutes = doc.select("Valute");
//                            for (Element valute : valutes) {
//                                if (valute.attr("ID").equals("R01235")) {
//                                    result = valute.select("Value").text();
//                                    System.out.println(result);
//                                }
//                            }
//                        }
//                        if (incomeMessage.equals("2")) {
//                            int number = Integer.parseInt(incomeMessage);
//                            Document doc = Jsoup.connect("https://lenta.ru/rss").get();
//                            int index = number - 1;
//                            Element news = doc.select("item").get(index);
//                            String category = news.select("category").text();
//                            String title = news.select("title").text();
//                            String link = news.select("link").text();
//                            String description = news.select("description").text();
//                            result = category + "\n" + title + "\n" + description + "\n" + link;
//                        }
//
//                        if (incomeMessage.equals("3")) {
//                            String movieName = incomeMessage;
//                            String jsonString = Jsoup.connect("https://itunes.apple.com/search?media=movie&term=" + movieName)
//                                    .ignoreContentType(true)
//                                    .execute()
//                                    .body();
//                            ObjectMapper objectMapper = new ObjectMapper();
//                            var jsonNode = objectMapper.readTree(jsonString);
//                            result = jsonNode.get("results").get(0).get("previewUrl").asText();
//                            System.out.println(result);
//                        }
//                        //send response
//                        SendMessage request = new SendMessage(chatId, result);
//                        bot.execute(request);
//
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                });
//                return UpdatesListener.CONFIRMED_UPDATES_ALL;
//            }
//        });
//    }
//}
