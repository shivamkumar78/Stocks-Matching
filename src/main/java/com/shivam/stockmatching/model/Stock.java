package com.shivam.stockmatching.model;

public class Stock {
    
    EXCH exch;
    String name;
    Double price;


    public Stock(EXCH exch, String name, Double price) {
        this.exch = exch;
        this.name = name;
        this.price = price;
    }

    public EXCH getExch() {
        return exch;
    }

    public void setExch(EXCH exch) {
        this.exch = exch;
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
    
}
