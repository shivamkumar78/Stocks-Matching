package com.shivam.stockmatching.service;

import com.shivam.stockmatching.model.Order;

public class OrderManager {
    
    OrderValidation orderValidation=new OrderValidation();
    OrderExecution execution=new OrderExecution();

    public void placeOrder(String userId,Order order){
        if(orderValidation.ValidateOrder(userId, order)){
            execution.placeOrder(userId, order);
        }
        
    }
}
