package com.shop.manager;


import com.shop.model.Product;
import com.shop.model.Order;

public class ShopManager {
    private Product[] products;
    private int productCount;
    private Order[] orders;
    private int orderCount;

    public ShopManager() {
        products = new Product[50];
        productCount = 0;
        orders = new Order[50];
        orderCount = 0;
    }

    // ===== 상품 관리 =====

    public void addProduct(Product product) {
        if (productCount >= products.length) {
            System.out.println("더 이상 상품을 추가할 수 없습니다.");
            return;
        }
        products[productCount++] = product;
        System.out.println("[상품 등록] " + product.getName() + " - " + product.getPrice() + "원");
    }

    public Product findProductById(String id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] searchProductsByName(String keyword) {
        Product[] result = new Product[productCount];
        int count = 0;

        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                result[count++] = products[i];
            }
        }

        Product[] finalResult = new Product[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public Product[] searchProductsByCategory(String category) {
        Product[] result = new Product[productCount];
        int count = 0;

        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                result[count++] = products[i];
            }
        }

        Product[] finalResult = new Product[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public void printAllProducts() {
        System.out.println("=== 전체 상품 목록 ===");
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            System.out.println((i + 1) + ". [" + p.getId() + "] " + p.getName() + " - " + p.getPrice() + "원 (재고: " + p.getStock() + "개)");
        }
    }

    // ===== 주문 관리 =====

    public Order createOrder() {
        Order order = new Order();
        System.out.println("[주문 생성] " + order.getOrderId());
        return order;
    }

    public void addOrderItem(Order order, String productId, int quantity) {
        Product product = findProductById(productId);
        if (product == null) {
            System.out.println("[에러] 상품을 찾을 수 없습니다.");
            return;
        }

        if (!product.isAvailable(quantity)) {
            System.out.println("[에러] 재고가 부족합니다.");
            return;
        }

        order.addItem(productId, quantity);
        System.out.println("[주문 항목 추가] " + product.getName() + " x " + quantity);
    }

    public void processOrder(Order order) {
        // 총 금액 계산
        order.calculateTotal(this);

        System.out.println("\n=== 주문 내역 ===");
        System.out.println("주문번호: " + order.getOrderId());
        System.out.println("----------------------------");

        // 주문 상품 출력
        String[] productIds = order.getProductIds();
        int[] quantities = order.getQuantities();

        for (int i = 0; i < order.getItemCount(); i++) {
            Product product = findProductById(productIds[i]);
            if (product != null) {
                int subtotal = product.getPrice() * quantities[i];
                System.out.println(product.getName() + " x " + quantities[i] + " = " + subtotal + "원");
            }
        }

        System.out.println("----------------------------");
        System.out.println("총 금액: " + order.getTotalAmount() + "원");

        // 재고 차감
        for (int i = 0; i < order.getItemCount(); i++) {
            Product product = findProductById(productIds[i]);
            if (product != null) {
                product.decreaseStock(quantities[i]);
            }
        }

        // 주문 완료
        order.complete();

        // 주문 배열에 추가
        if (orderCount < orders.length) {
            orders[orderCount++] = order;
        }

        System.out.println("\n[결제 완료] " + order.getOrderId());
    }

    public Order findOrderById(String orderId) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getOrderId().equals(orderId)) {
                return orders[i];
            }
        }
        return null;
    }

    public void printAllOrders() {
        System.out.println("=== 전체 주문 ===");
        for (int i = 0; i < orderCount; i++) {
            Order order = orders[i];
            System.out.println((i + 1) + ". [" + order.getOrderId() + "] " + order.getTotalAmount() + "원 (" + order.getStatus() + ")");
        }
    }
}