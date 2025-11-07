package com.shop;

import com.shop.model.Product;
import com.shop.model.Order;
import com.shop.manager.ShopManager;

public class ShopApp {
    public static void main(String[] args) {

        ShopManager manager = new ShopManager();

        // ===== 시나리오 1: 초기 데이터 설정 =====
        System.out.println(">>> 시나리오 1: 초기 데이터 설정\n");

        Product product1 = new Product("노트북", 1500000, 5, "전자기기");
        Product product2 = new Product("마우스", 30000, 20, "전자기기");
        Product product3 = new Product("Java책", 35000, 10, "도서");
        Product product4 = new Product("키보드", 80000, 15, "전자기기");

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        System.out.println();

        // ===== 시나리오 2: 상품 조회 =====
        System.out.println(">>> 시나리오 2: 상품 조회\n");

        manager.printAllProducts();
        System.out.println();

        System.out.println("[검색: 전자기기]");
        Product[] electronics = manager.searchProductsByCategory("전자기기");
        for (int i = 0; i < electronics.length; i++) {
            Product p = electronics[i];
            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice() + "원");
        }
        System.out.println();

        // ===== 시나리오 3: 주문 생성 및 처리 =====
        System.out.println(">>> 시나리오 3: 주문 생성 및 처리\n");

        Order order = manager.createOrder();
        System.out.println();

        manager.addOrderItem(order, product1.getId(), 1);
        manager.addOrderItem(order, product2.getId(), 2);
        manager.addOrderItem(order, product4.getId(), 1);
        System.out.println();

        manager.processOrder(order);
        System.out.println();

        // ===== 시나리오 4: 전체 조회 =====
        System.out.println(">>> 시나리오 4: 전체 조회\n");

        manager.printAllOrders();
        System.out.println();

        System.out.println("=== 재고 현황 ===");
        manager.printAllProducts();

    }
}