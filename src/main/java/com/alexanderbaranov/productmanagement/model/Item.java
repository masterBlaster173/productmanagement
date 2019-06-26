package com.alexanderbaranov.productmanagement.model;

import java.io.Serializable;

public class Item implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String type;

    public Item() {
    }

    public Item(Long id, String name, Double price, String description, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
