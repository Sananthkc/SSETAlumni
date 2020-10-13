package com.pro.ssetalumni;

public class Listdata {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public String getHost() {
        return host;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String id;
    public String title;
    public String desc;
    public  String date;
    public  String host;

    public Listdata() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Listdata(String id, String title, String desc, String date, String host) {
        this.id=id;
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.host = host;

    }

}