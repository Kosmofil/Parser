package controller;

import model.DataSaver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


public class ParseJson {
    private Document doc = null;
    private Collection<DataSaver> quotes = new ArrayList<>();

    // TODO: 18.02.17 у новостей нет заголовков в quotes есть null испавить
    public Collection<DataSaver> connect() {

        try {
            doc = Jsoup.connect("https://habrahabr.ru").userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final List<Element> elms = doc.select(".shortcuts_item");//".post__header"
        final Stream<Element> streamElement = elms.stream();
// TODO: 18.02.17 сделать полное раскрытие новости 
        streamElement.forEachOrdered((elem) -> {
            String title = getText(elem, "a[class=post__title_link]");
            String urlNews = getURL(elem, "div[class=buttons]");
            String data = getText(elem, "div[class=content html_format]");
            quotes.add(new DataSaver(title, urlNews, data));
        });
return quotes;
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

}
