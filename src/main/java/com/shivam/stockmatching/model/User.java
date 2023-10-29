package com.shivam.stockmatching.model;

public class User {
    
    String userId;
    double funds;

    public User(String userId,double funds) {
        this.userId = userId;
        this.funds = funds;
    }
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public double getFunds() {
        return funds;
    }
    public void setFunds(double funds) {
        this.funds = funds;
    }
    
}
