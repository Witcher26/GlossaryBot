package com.zvezdilin.TelegramBot.model.entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
        var date = "09/08/2022";
        Document doc = Jsoup.connect("https://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date).get();
        System.out.println(doc.title());
        Elements valutes = doc.select("Valute");
        for(Element valute: valutes){
           if(valute.attr("ID").equals("R01235")) {
               String result = valute.select("Value").text();
                System.out.println(result);
            }
        }
    }
}
