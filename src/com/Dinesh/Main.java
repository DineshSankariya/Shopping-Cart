package com.Dinesh;

import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);

    private static GrocerShop grocerShop=new GrocerShop("Big Bazaar","1345786","Los Angels");

    public static void main(String[] args) {


        boolean go=false;
        while (!go){
            action();
            System.out.println("Enter your choice : ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){

                case 1:
                    add_item();
                    break;
                case 2:
                    add_customer();
                    break;
                case 3:
                    add_item_product();
                    break;
                case 4:
                    print_bill();
                    break;
                case 5:
                    print_invoice();
                    break;
                case 6:
                    go=true;
                    break;
                default:
                    go=true;
                    break;

            }

        }


    }

    private static void action(){

        System.out.println("1 - Add New Product to Grocery\n2 - Add New Customer\n3 - Add Item to customer's basket\n"+
                "4 - Print Customer's  Bill\n5 - Print Invoice of Customer\n6 - End Shopping.");
    }

    private static void add_item(){


        System.out.println("Enter item name : ");
        String name=scanner.nextLine();

        System.out.println("Enter item price : ");
        Double  price=scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter "+name+" initial stock : ");
        int stock=scanner.nextInt();

        if(grocerShop.add_item(new Item(name,stock,price))){
            System.out.println(name+" added ");
        }else {
            System.out.println(name+" not added ");
        }

    }

    private static void add_customer(){


        System.out.println("Enter Customer name : ");
        String name=scanner.nextLine();

        System.out.println("Enter Mobile Number : ");
        String number=scanner.nextLine();

        if(grocerShop.add_cust(new Customer(name,number,new Basket()))){
            System.out.println(name+" added ");
        }else {
            System.out.println(name+" not added ");
        }


    }

    private static void add_item_product(){

        System.out.println("Enter Customer name : ");
        String name=scanner.nextLine();

        System.out.println("Enter item name : ");
        String item=scanner.nextLine();

        System.out.println("Enter "+item+" quantity : ");
        int quantity=scanner.nextInt();
        scanner.nextLine();

        if(grocerShop.add_item_cust(name,item,quantity)){
            System.out.println(item+" with number of quantity "+quantity+" added to "+name+"'s basket.");
        }else {
            System.out.println("Not added to basket");
        }

    }

    private static void print_bill(){

        System.out.println("Enter Customer name : ");
        String name=scanner.nextLine();
        grocerShop.print_bill(name);
    }

    private static void print_invoice(){

        System.out.println("Enter Customer name : ");
        String name=scanner.nextLine();
        grocerShop.print_invoice(name);
    }


}
