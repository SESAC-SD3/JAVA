package com.shop.model;


import com.shop.utils.IdGenerator;
import com.shop.manager.ShopManager;

public class Order {
    private String orderId;
    private String[] productIds;
    private int[] quantities;
    private int itemCount;
    private int totalAmount;
    private String status;  // "결제대기", "결제완료", "취소"

    public Order() {
        this.orderId = IdGenerator.getInstance().generateOrderId();
        this.productIds = new String[10];
        this.quantities = new int[10];
        this.itemCount = 0;
        this.totalAmount = 0;
        this.status = "결제대기";
    }

    // Getter
    public String getOrderId() {
        return orderId;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    // 상품 추가
    public void addItem(String productId, int quantity) {
        if (itemCount >= 10) {
            throw new IllegalStateException("주문은 최대 10개 상품까지 가능합니다.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        }

        productIds[itemCount] = productId;
        quantities[itemCount] = quantity;
        itemCount++;
    }

    // 총 금액 계산
    public void calculateTotal(ShopManager manager) {
        totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            Product product = manager.findProductById(productIds[i]);
            if (product != null) {
                totalAmount += product.getPrice() * quantities[i];
            }
        }
    }

    // 주문 완료
    public void complete() {
        this.status = "결제완료";
    }
}
