package com.geekbrains.spring.webjs.data;

public class Product {
    private Long id;
    private String title;
    private String unit;
    private Float cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Product() {
    }

    public Product(Long id, String title, String unit, Float cost) {
        this.id = id;
        this.title = title;
        this.unit = unit;
        this.cost = cost;
    }
}
