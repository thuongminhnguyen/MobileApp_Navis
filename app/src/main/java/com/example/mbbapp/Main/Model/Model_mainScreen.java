package com.example.mbbapp.Main.Model;

public class Model_mainScreen {
    private String item_name
            ;
    private int imgid;

    public Model_mainScreen(String course_name, int imgid) {
        this.item_name = course_name;
        this.imgid = imgid;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
