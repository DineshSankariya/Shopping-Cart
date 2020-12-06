package com.Dinesh;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Customer {

    private String name;

    private String mobile;

    private Double totalbill=0.0;

    private Basket basket;
//    private List<Item> items;
//
//    private List<Customer> customers;
//
//    private HashMap<Date,Customer> invoice;

    public Customer(String name, String mobile,Basket basket) {
        this.name = name;
        this.mobile = mobile;
        this.basket=basket;
//        this.customers=new ArrayList<>();
//        this.items=new ArrayList<>();
//        this.invoice=new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Double getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(Double totalbill) {
        this.totalbill = totalbill;
    }
}
