package com.indev.blackfriday;

import java.util.HashMap;
import java.util.Map;

public class Company {
    HashMap<Product, Integer> productStock;
    final int USUAL_SELL_QUANTITY = 5;
    final int BLACK_FRIDAY_SELL_QUANTITY = 10;

    final float GAIN_PERCENTAGE = 0.2f;
    final float BLACK_FRIDAY_GAIN_PERCENTAGE = 0.1f;

    int sellQuantity = USUAL_SELL_QUANTITY;
    float gainPercentage=GAIN_PERCENTAGE;

    int totalAssets = 0;
    int gain = 0;


    public Company() {
        initStock();
    }


    public void stock(int quantity, String productName, int price) {
        if (productStock.get(getProductByName(productName)) == null)
            productStock.put(Product.createProductUsingPriceAndName(price, productName), quantity);
        else
            productStock.replace(getProductByName(productName), productStock.get(getProductByName(productName)), (productStock.get(getProductByName(productName)) + quantity));

    }


    public float sells(String productName) throws RuntimeException {
        float salePrice = (sellQuantity * getProductByName(productName).getPrice()) * (1 + gainPercentage);
        if (productStock.get(getProductByName(productName)) < sellQuantity)
            throw new RuntimeException("Stock Insufisant");
        productStock.replace(getProductByName(productName), productStock.get(getProductByName(productName)), (productStock.get(getProductByName(productName)) - sellQuantity));
        gain += salePrice;

        return salePrice;
    }

    public Product getProductByName(String productName) {
        for (Map.Entry<Product, Integer> entry : productStock.entrySet()) {
            if (entry.getKey().getName() == productName) return entry.getKey();
        }
        return null;
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {

        totalAssets = 0;
        for (Map.Entry<Product, Integer> entry : productStock.entrySet()) {
            totalAssets += entry.getKey().getPrice() * entry.getValue();

        }
        totalAssets += gain;


        return totalAssets;
    }

    public Company blackFriday() {
        sellQuantity = BLACK_FRIDAY_SELL_QUANTITY;
        gainPercentage=BLACK_FRIDAY_GAIN_PERCENTAGE;
        return this;
    }


    public void initStock() {
        productStock = new HashMap<Product, Integer>();
    }


}
