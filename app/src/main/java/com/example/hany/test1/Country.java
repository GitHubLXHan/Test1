package com.example.hany.test1;

/**
 * @author 6小h
 * @e-mail 1026310040@qq.com
 * @date 2018/10/20 16:35
 * @filName Country
 * @describe ...
 */
public class Country {

    private String name;

    private int imageId;

    public Country(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
