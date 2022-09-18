package com.example.test.pojo;

import java.util.Date;

public class product {
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Date date;

    private String permise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPermise() {
        return permise;
    }

    public void setPermise(String permise) {
        this.permise = permise;
    }
}