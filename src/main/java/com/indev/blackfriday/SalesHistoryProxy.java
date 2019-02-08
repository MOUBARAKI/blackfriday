package com.indev.blackfriday;

import java.util.HashMap;
import java.util.Map;

public class SalesHistoryProxy {
    HashMap<Product,Integer> salesHistory ;
    public SalesHistoryProxy(HashMap<Product, Integer> salesHistory) {
        this.salesHistory=salesHistory;
    }

    public String salesHistory(){
        String sales="";
        for (Map.Entry<Product, Integer> entry : salesHistory.entrySet()) {
            sales+=entry.getValue()+":"+entry.getKey().getName()+"s";
        }
        return sales;
    }
}
