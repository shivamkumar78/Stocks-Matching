package com.shivam.stockmatching.service;

import com.shivam.stockmatching.model.ExchangeConnector;
import com.shivam.stockmatching.model.Order;

public class OrderExecution {
    
    public void placeOrder(String userId,Order order){

        ExchangeConnector exch=ExchangeConnector.getConnector();
        exch.addOrder(order);
        exch.matchOrder();     
    }

}
