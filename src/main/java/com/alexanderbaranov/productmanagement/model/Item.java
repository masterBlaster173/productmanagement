package com.alexanderbaranov.productmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Item implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    private String description;

    @Column(name = "type", nullable = false)
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
