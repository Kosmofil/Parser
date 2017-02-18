package controller;

import model.DataSaver;

import java.util.ArrayList;
import java.util.List;

public class CollectStatistics {


    public static int quantityNews(List<DataSaver> saver){

        int count = 0;
        for (int i = 0; i < saver.size(); i++)
        {
            if (saver.contains(i));
            count++;
        }
        return count;
    }

}
