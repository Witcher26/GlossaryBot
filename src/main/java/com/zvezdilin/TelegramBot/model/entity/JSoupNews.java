//package com.zvezdilin.TelegramBot.model.entity;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
//public class JSoupNews {
//
//    public static void main(String[] args) throws IOException {
//        //пользователь даёт на вход номер новости, мы её ему возвращаем
//        int number = 1;
//        Document doc = Jsoup.connect("https://lenta.ru/rss").get();
//        int index = number - 1;
//        Element news = doc.select("item").get(index);
//        String category = news.select("category").text();
//        String title = news.select("title").text();
//        String link = news.select("link").text();
//        String description = news.select("description").text();
//        String result = category + "\n" + title + "\n" + description + "\n" + link;
//        System.out.println(result);
//    }
//}
