package model;

public class KaolaPic {
    private Integer id;

    private String url;

    private String name;

    private Integer downloadresult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDownloadresult() {
        return downloadresult;
    }

    public void setDownloadresult(Integer downloadresult) {
        this.downloadresult = downloadresult;
    }
}
