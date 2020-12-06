package com.Dinesh;

public class Item {

    private String name;

    private Double value;

    private int stock;

    public Item(String name, int stock,Double value) {
        this.name = name;
        this.stock = stock;
        this.value=value;
    }

    public void add_stock(int add){
        this.stock+=add;
    }

    public void deduct_stock(int deduct){
        this.stock-=deduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
