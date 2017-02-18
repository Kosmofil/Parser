package model;

public class DataSaver {

    private String urlNews;
    private String title;
    private String data;
    private int count;

    public DataSaver(final int count, final String title, final String urlNews, final String data) {
        this.count = count;
        this.title = title;
        this.urlNews = urlNews;
        this.data = data;
    }

    public String getUrl() {
        return urlNews;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }
}
