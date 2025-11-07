package com.shop.utils;

public class IdGenerator {
    private static IdGenerator instance;

    private int productIdCounter;
    private int orderIdCounter;

    private IdGenerator() {
        this.productIdCounter = 1;
        this.orderIdCounter = 1;
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public String generateProductId() {
        return "P" + productIdCounter++;
    }

    public String generateOrderId() {
        return "O" + orderIdCounter++;
    }
}