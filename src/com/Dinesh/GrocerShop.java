package com.Dinesh;

import java.util.*;

public class GrocerShop {

    private String name;

    private String mobile;

    private String area;

    private List<Item> items;

    private List<Customer> customers;

    private HashMap<Date,Customer> invoice;

    public GrocerShop(String name, String mobile, String area) {
        this.name = name;
        this.mobile = mobile;
        this.area = area;
        this.customers=new ArrayList<>();
        this.items=new ArrayList<>();
        this.invoice=new HashMap<>();
    }

    //check item exist in list before going to add
    public int check_item(String item){
        for (int i=0;i<items.size();i++
             ) {
            if(items.get(i).getName().toLowerCase().equals(item.toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    //check customer exist before adding
    public int check_customer(String customer){
        for (int i=0;i<customers.size();i++
        ) {
            if(customers.get(i).getName().toLowerCase().equals(customer.toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    //add customer to list
    public boolean add_cust(Customer cust){

        int pos=check_customer(cust.getName());
        if(pos>=0){
            // customer exists already
            return false;
        }else {
            this.customers.add(cust);
        }

        return true;
    }

    //add item to list
    public boolean add_item(Item item){

        int pos=check_item(item.getName());
        if(pos>=0){
            // Item exists already
            return false;
        }else {
            this.items.add(item);
        }

        return true;
    }

    //add item to a specific customer's basket
    public boolean add_item_cust(String cust,String item,int quantity){

        int a=check_customer(cust);
        int b=check_item(item);
        if(a>=0 && b>=0){

            Customer find=this.customers.get(a);
            Item find_item=this.items.get(b);
            HashMap<Item,Integer> cust_basket=find.getBasket().getBasket();
            if(cust_basket.containsKey(find_item)){
                cust_basket.put(find_item,cust_basket.get(find_item)+quantity);
            }else {
                cust_basket.put(find_item,quantity);
            }
            return true;

        }else {
            return false;
        }

    }

    public void print_bill(String customername) {

        int pos = check_customer(customername);
        if (pos >= 0) {
            Double totalbill = 0.0;
            Customer find = this.customers.get(pos);

            System.out.println("Customer Name : " + find.getName() + " Contact : " + find.getMobile());
            for (Map.Entry<Item, Integer> e : find.getBasket().getBasket().entrySet()
            ) {
                System.out.println("Product Name => " + e.getKey().getName() + ", Price :  " + e.getKey().getValue() + " Quantity => " + e.getValue() + " Amount => " + e.getKey().getValue() * e.getValue());
                totalbill += e.getKey().getValue() * e.getValue();
            }
            if (totalbill != 0) {

                System.out.println("Total Bill to pay => " + totalbill);
                find.setTotalbill(totalbill);
                this.invoice.put(new Date(), find);

            }


        }
    }

    public void print_invoice(String customer){

        for (Map.Entry<Date,Customer> b:this.invoice.entrySet()
             ) {
            if(b.getValue().getName().toLowerCase().equals(customer.toLowerCase())){

                Customer find=b.getValue();

                System.out.println("Date and Time : "+b.getKey().toString()+"Customer Name : " + find.getName() + " Contact : " + find.getMobile());
                for (Map.Entry<Item, Integer> e : find.getBasket().getBasket().entrySet()
                ) {
                    System.out.println("Product Name => " + e.getKey().getName() + ", Price :  " + e.getKey().getValue() + " Quantity => " + e.getValue() + " Amount => " + e.getKey().getValue() * e.getValue());
//                    totalbill += e.getKey().getValue() * e.getValue();
                }

                System.out.println("Total Bill to pay => " + find.getTotalbill());

            }
        }













    }










}
