package com.bwie.sunli20181203.bean;

public class SearchBean {
    private String title;
    private String uuid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public SearchBean(String title, String uuid) {
        this.title = title;
        this.uuid = uuid;
    }
}
