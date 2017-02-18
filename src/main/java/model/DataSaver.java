package model;

public class DataSaver {

    private String urlNews;
    private String title;
    private String data;

    public DataSaver(final String title, final String urlNews, final String data) {
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

    @Override
    public String toString() {
        return
                "Заголовок новости = " + title +
                ", urlNews = " + urlNews +
                ", краткая новость = " + data
                + "\n"
                ;
    }

}
