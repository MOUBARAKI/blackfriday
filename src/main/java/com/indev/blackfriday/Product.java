package com.indev.blackfriday;

public class Product {
    int price;
    String name;

    private Product(int price, String name ) {
        this.price = price;
        this.name=name;
    }

    public static Product createProductUsingPriceAndName(int price, String name ) {
        Product product = new Product(price,name);
        return product;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
