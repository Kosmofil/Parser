package controller;

import model.DataSaver;
import java.util.*;
import java.util.stream.Collectors;


public class CollectStatistics {

    public static void showAll(Collection<DataSaver> saver) {
        List<DataSaver> select = saver.stream().filter((s) -> s.getTitle() != null).collect(Collectors.toList());
        System.out.println(select);
    }

    public static long quantityNews(Collection<DataSaver> saver) {
        long result = saver.stream().filter((p) -> p.getTitle() != null).count();
        return result;
    }

    //вывод новости по введенному числу
    public static void showNewsAtNumber(Collection<DataSaver> saver, int num) {
        DataSaver list = saver.stream().skip(num).findFirst().get();
        System.out.println(list.getData());
    }

//кол-во слов в новости
    public static long words(Collection<DataSaver> saver, int num){
        long result = 0;
        DataSaver list = saver.stream().skip(num).findFirst().get();
       String[] temp = list.getData().split(" ");
        result = Arrays.stream(temp).count();
        return result;
    }
}
