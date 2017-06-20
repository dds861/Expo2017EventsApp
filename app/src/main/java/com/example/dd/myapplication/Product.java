package com.example.dd.myapplication;

/**
 * Created by dd on 11.06.2017.
 */

public class Product {


    String text1;
    String text2;


    String text3;
    int image;
    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Product(String text1, String text2, String text3, int image) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.image = image;
    }
}
