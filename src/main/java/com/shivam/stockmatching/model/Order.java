package com.shivam.stockmatching.model;

public class Order {

    TXN_TYPE txn_Type;
    ORDER_TYPE orderType;
    double price;
    int qty;
    Stock stock;
    EXCH exch;

    public Order(TXN_TYPE txn_Type, ORDER_TYPE orderType, double price, int qty, Stock stock, EXCH exch) {
        this.txn_Type = txn_Type;
        this.orderType = orderType;
        this.price = price;
        this.qty = qty;
        this.stock = stock;
        this.exch = exch;
    }

    public TXN_TYPE getTxn_Type() {
        return txn_Type;
    }

    public void setTxn_Type(TXN_TYPE txn_Type) {
        this.txn_Type = txn_Type;
    }

    public ORDER_TYPE getOrderType() {
        return orderType;
    }

    public void setOrderType(ORDER_TYPE orderType) {
        this.orderType = orderType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public EXCH getExch() {
        return exch;
    }

    public void setExch(EXCH exch) {
        this.exch = exch;
    }

}
