package controller;

import model.Choice;
import model.DataSaver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ParseJson {
    private Document doc = null;
    private List<DataSaver> quotes = new ArrayList<>();


    public void connect() {

        try {
            doc = Jsoup.connect("https://habrahabr.ru").userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final List<Element> elms = doc.select(".shortcuts_item");//".post__header"

        elms.forEach((elem) -> {
            int count = 0;
            String title = getText(elem, "a[class=post__title_link]");
            String urlNews = getURL(elem, "div[class=buttons]");
            String data = getText(elem, "div[class=content html_format]");
            quotes.add(new DataSaver(count++, title, urlNews, data));
        });

    }

    private static String getURL(Element element, String cssQuery) {//обрабатываю ссылку, надо переделать!!!
        final Element result = element.select(cssQuery).first();
        if (result != null) {
            return result.html()
                    .replaceAll("<a class=\"button\" href=\"", "")
                    .replaceAll("\">Читать дальше →</a>", "")
                    .replaceAll("(<br>)\n+(\\1)*", "\n")
                    .replaceAll("<br>", "");

        }
        return null;
    }

    private static String getText(Element element, String cssQuery) {//получаем текст
        final Element result = element.select(cssQuery).first();
        if (result != null) {
            return result.text();
        }
        return null;
    }

    //выбераем что отобразить
    public void showNewsWithChoice(Choice choice) {
        switch (choice) {
            case title:
                for (DataSaver text : quotes) {
                    System.out.println(text.getTitle());
                }
                break;
            case url:
                for (DataSaver text : quotes) {
                    System.out.println(text.getUrl());
                }
                break;
            case text:
                for (DataSaver text : quotes) {
                    System.out.println(text.getData());
                }
                break;
        }

    }


}
