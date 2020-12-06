package com.Dinesh;

import java.util.HashMap;

public class Basket {

    HashMap<Item,Integer> basket;

    public Basket() {
        this.basket=new HashMap<>();
    }

    public HashMap<Item, Integer> getBasket() {
        return basket;
    }
}
