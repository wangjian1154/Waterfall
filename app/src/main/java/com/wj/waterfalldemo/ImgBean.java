package com.wj.waterfalldemo;

public class ImgBean {

    private String imgPath;

    private int width;

    private int height;

    public ImgBean(String imgPath, int width, int height) {
        this.imgPath = imgPath;
        this.width = width;
        this.height = height;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
