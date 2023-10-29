package com.shivam.stockmatching.service;

import com.shivam.stockmatching.model.Order;
import com.shivam.stockmatching.repository.Db;


public class OrderValidation {

    boolean ValidateOrder(String userId, Order order) {

    Db db=Db.getConnector();

    return db.checkUserFund(userId,order);

    }
}
