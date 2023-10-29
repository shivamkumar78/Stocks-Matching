package com.shivam.stockmatching.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class ExchangeConnector {

    static ExchangeConnector exchangeConnector;
    static Map<String, PriorityQueue<Order>> buyOrders;   //stored different stocks into different queues on the basis of name
    static Map<String, PriorityQueue<Order>> sellOrders;

    public static Map<String, PriorityQueue<Order>> getBuyOrders() {
        return buyOrders;
    }

    public static void setBuyOrders(Map<String, PriorityQueue<Order>> buyOrders) {
        ExchangeConnector.buyOrders = buyOrders;
    }

    public static Map<String, PriorityQueue<Order>> getSellOrders() {
        return sellOrders;
    }

    public static void setSellOrders(Map<String, PriorityQueue<Order>> sellOrders) {
        ExchangeConnector.sellOrders = sellOrders;
    }

    private ExchangeConnector() {

        if (exchangeConnector != null) {
            throw new RuntimeException("Instance already created");
        }

    }

    public static ExchangeConnector getConnector() {

        if (exchangeConnector == null) {

            synchronized (ExchangeConnector.class) {

                if (exchangeConnector == null) {
                    exchangeConnector = new ExchangeConnector();
                    buyOrders=new HashMap<>();
                    sellOrders=new HashMap<>();
                }
            }
        }
        return exchangeConnector;
    }

    public void addOrder(Order order) {

        if (TXN_TYPE.BUY==order.getTxn_Type()) {

            buyOrders.putIfAbsent(order.getStock().getName(), new PriorityQueue<Order>());
            buyOrders.get(order.getStock().getName()).add(order);
        } else if (TXN_TYPE.SELL==order.getTxn_Type()) {
            sellOrders.putIfAbsent(order.getStock().getName(), new PriorityQueue<Order>());
            sellOrders.get(order.getStock().getName()).add(order);
        }
    }

    public void matchOrder() {

        for (String symbol : buyOrders.keySet()) {

            if (sellOrders.containsKey(symbol)) {

                PriorityQueue<Order> buyQueue = buyOrders.get(symbol);
                PriorityQueue<Order> sellQueue = sellOrders.get(symbol);

                while (!buyQueue.isEmpty() && !sellQueue.isEmpty()) {

                    Order bestBuy = buyQueue.peek();
                    Order bestSell = sellQueue.peek();

                    if (bestBuy.getPrice() >= bestSell.getPrice()) {

                        int matchedQuantity = Math.min(bestBuy.getQty(), bestSell.getQty());
                        System.out.println(
                                "Matched " + bestBuy.getStock().getName() + "- Price " + bestBuy.getStock().getName() + ",Quantity"
                                        + matchedQuantity);
                        int b=bestBuy.getQty() - matchedQuantity;
                        int s=bestSell.getQty()- matchedQuantity;

                        if (b == 0)
                            buyQueue.poll();

                        if (s == 0)
                            sellQueue.poll();

                    } else {
                        System.out.println("Can't deal");
                        break;
                    }
                }
            }
        }
    }

}
