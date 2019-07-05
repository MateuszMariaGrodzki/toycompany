package com.toycompany.demo.Model;

import javax.persistence.Embeddable;

@Embeddable
public class Toy {

    private String name;
    private String content;
    private int pricePerHour;
    private int categoryId;

    public Toy(String name, String content, int pricePerHour, int categoryId) {
        this.name = name;
        this.content = content;
        this.pricePerHour = pricePerHour;
        this.categoryId = categoryId;

    }

    public Toy(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
