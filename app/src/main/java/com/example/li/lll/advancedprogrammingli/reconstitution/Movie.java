package com.example.li.lll.advancedprogrammingli.reconstitution;

public class Movie {
    public static final int CHILDRENS =2;
    public static final int REGULAR =0;
    public static final int NEW_RELEASE =1;

    private String title;
    private String priceCode;

    public Movie(String title,String priceCode){
        this.title =title;
        this.priceCode =priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }
}
