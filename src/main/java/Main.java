/*/**
 *Created by kosmos on 16.02.17.
 * парсер новостного сайта, в функциональном стиле, вывод статистики, какие слова, какое количество
 * jsoup
 * stream api
 *
 */

import controller.CollectStatistics;
import controller.ParseJson;
import java.io.IOException;
import java.util.Collection;




public class Main {
    public static void main(String[] args) throws IOException {
        ParseJson habr = new ParseJson();
        Collection test = habr.connect();

        System.out.println("count news = "+ CollectStatistics.quantityNews(test));

        CollectStatistics.showAll(test);// выводим все новости название, ссылка, короткая новости
        CollectStatistics.showNewsAtNumber(test, 0);//выводим выбранную новость
        System.out.println(CollectStatistics.words(test, 1));// подсчитываем количество слов в новости
    }

}
