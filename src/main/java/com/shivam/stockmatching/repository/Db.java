package com.shivam.stockmatching.repository;

import java.util.HashMap;
import java.util.Map;

import com.shivam.stockmatching.model.Order;
import com.shivam.stockmatching.model.User;

public class Db {

    static Db exchangeConnector;
    static Map<String, User> users;

    public static Db getExchangeConnector() {
        return exchangeConnector;
    }

    public static void setExchangeConnector(Db exchangeConnector) {
        Db.exchangeConnector = exchangeConnector;
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<String, User> users) {
        Db.users = users;
    }

    private Db() {

        if (exchangeConnector != null) {
            throw new RuntimeException("Instance already created");
        }

    }

    public static Db getConnector() {

        if (exchangeConnector == null) {

            synchronized (Db.class) {

                if (exchangeConnector == null) {
                    exchangeConnector = new Db();
                    users = new HashMap<>();
                }
            }
        }
        return exchangeConnector;
    }

    public boolean checkUserFund(String userId, Order order) {

        User user = users.get(userId);

        if (user != null) {

            double funds = user.getFunds();
            double amt = order.getPrice() * order.getQty();

            if (funds >= amt)
                return true;
            else
                return false;
        }
        return false;

    }

    public void addFunds(String userId,User user){

        Db.users.put(userId, user);

    }

}
