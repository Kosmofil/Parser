/*/**
 *Created by kosmos on 16.02.17.
 * парсер новостного сайта, в функциональном стиле, вывод статистики, какие слова, какое количество
 * jsoup
 * stream api
 *
 */

import controller.CollectStatistics;
import controller.ParseJson;
import model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        ParseJson habr = new ParseJson();
        habr.connect();
      habr.showNewsWithChoice(Choice.url);

    }

}
