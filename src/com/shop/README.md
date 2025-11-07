
## 패키지 구조

```
com.shop/
├── model/
│   ├── Product.java        # 상품
│   └── Order.java          # 주문
├── manager/
│   └── ShopManager.java    # 재고 및 주문 관리
├── utils/
│   └── IdGenerator.java    # ID 생성 (싱글톤)
└── ShopApp.java            # 메인
```

**총 4개 클래스 + 메인 = 5개 파일**

---

## 클래스별 요구사항

### 1. IdGenerator.java (싱글톤)

**패키지:** `com.shop.utils`

**역할:** 상품 ID와 주문 ID를 자동으로 생성하는 싱글톤 클래스

**필드:**
```java
private static IdGenerator instance;  // 싱글톤 인스턴스
private int productIdCounter;         // 상품 ID 카운터
private int orderIdCounter;            // 주문 ID 카운터
```

**생성자:**
```java
private IdGenerator() {
    this.productIdCounter = 1;
    this.orderIdCounter = 1;
}
```

**메서드:**
1. `public static IdGenerator getInstance()`
    - 싱글톤 인스턴스 반환
    - instance가 null이면 새로 생성

2. `public String generateProductId()`
    - "P1", "P2", "P3" 형식으로 생성
    - `return "P" + productIdCounter++;`

3. `public String generateOrderId()`
    - "O1", "O2", "O3" 형식으로 생성
    - `return "O" + orderIdCounter++;`

**구현 팁:**
- 생성자를 private으로 선언하여 외부에서 생성 불가능하게 만들기
- getInstance()에서 instance가 null일 때만 new 키워드로 생성
- ID 생성은 간단하게: 접두사 + 숫자

---

### 2. Product.java

**패키지:** `com.shop.model`

**역할:** 상품 정보를 관리하는 클래스

**필드 (모두 private):**
```java
private String id;        // 상품 ID (자동 생성)
private String name;      // 상품명
private int price;        // 가격
private int stock;        // 재고
private String category;  // 카테고리
```

**생성자:**
```java
public Product(String name, int price, int stock, String category) {
    this.id = IdGenerator.getInstance().generateProductId();
    setName(name);     // setter를 통한 유효성 검증
    setPrice(price);
    setStock(stock);
    setCategory(category);
}
```

**Getter 메서드:**
- `public String getId()`
- `public String getName()`
- `public int getPrice()`
- `public int getStock()`
- `public String getCategory()`

**Setter 메서드 (유효성 검증 포함):**
1. `public void setName(String name)`
    - null이나 빈 문자열 체크
    - `throw new IllegalArgumentException("상품명은 필수입니다.");`

2. `public void setPrice(int price)`
    - 0 미만 체크
    - `throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");`

3. `public void setStock(int stock)`
    - 0 미만 체크
    - `throw new IllegalArgumentException("재고는 0 이상이어야 합니다.");`

4. `public void setCategory(String category)`
    - null이나 빈 문자열 체크

**재고 관리 메서드:**
1. `public void decreaseStock(int quantity)`
    - 수량이 0보다 큰지 확인
    - 재고가 충분한지 확인 (stock < quantity면 예외 발생)
    - stock -= quantity

2. `public void increaseStock(int quantity)`
    - 수량이 0보다 큰지 확인
    - stock += quantity

3. `public boolean isAvailable(int quantity)`
    - return stock >= quantity

**구현 팁:**
- 생성자에서 setter를 호출하면 중복 코드를 줄일 수 있음
- IdGenerator는 싱글톤이므로 `IdGenerator.getInstance()`로 호출

---

### 3. Order.java

**패키지:** `com.shop.model`

**역할:** 주문 정보를 관리하는 클래스 (배열로 간단히 관리)

**필드 (모두 private):**
```java
private String orderId;           // 주문 ID (자동 생성)
private String[] productIds;      // 주문한 상품 ID 배열 (크기 10)
private int[] quantities;         // 각 상품의 수량 배열 (크기 10)
private int itemCount;            // 현재 담긴 상품 종류 수
private int totalAmount;          // 총 금액
private String status;            // 주문 상태: "결제대기", "결제완료", "취소"
```

**생성자:**
```java
public Order() {
    this.orderId = IdGenerator.getInstance().generateOrderId();
    this.productIds = new String[10];
    this.quantities = new int[10];
    this.itemCount = 0;
    this.totalAmount = 0;
    this.status = "결제대기";
}
```

**Getter 메서드:**
- `public String getOrderId()`
- `public String[] getProductIds()`
- `public int[] getQuantities()`
- `public int getItemCount()`
- `public int getTotalAmount()`
- `public String getStatus()`

**주문 관리 메서드:**
1. `public void addItem(String productId, int quantity)`
    - 배열이 가득 찼는지 확인 (itemCount >= 10)
    - 수량이 1 이상인지 확인
    - productIds[itemCount]에 상품 ID 저장
    - quantities[itemCount]에 수량 저장
    - itemCount 증가

2. `public void calculateTotal(ShopManager manager)`
    - totalAmount를 0으로 초기화
    - 반복문으로 모든 상품 순회 (0부터 itemCount-1까지)
    - manager.findProductById()로 상품 찾기
    - totalAmount += product.getPrice() * quantities[i]

3. `public void complete()`
    - status를 "결제완료"로 변경


---

### 4. ShopManager.java (재고 및 주문 관리)

**패키지:** `com.shop.manager`

**역할:** 상품과 주문을 통합 관리하는 클래스

**필드 (모두 private):**
```java
private Product[] products;  // 상품 배열 (크기 50)
private int productCount;    // 현재 등록된 상품 수
private Order[] orders;      // 주문 배열 (크기 50)
private int orderCount;      // 현재 주문 수
```

**생성자:**
```java
public ShopManager() {
    products = new Product[50];
    productCount = 0;
    orders = new Order[50];
    orderCount = 0;
}
```

**상품 관리 메서드:**

1. `public void addProduct(Product product)`
    - 배열이 가득 찼는지 확인
    - products[productCount++] = product
    - 등록 메시지 출력
    - 예시: `System.out.println("[상품 등록] " + product.getName() + " - " + product.getPrice() + "원");`

2. `public Product findProductById(String id)`
    - 반복문으로 products 배열 순회
    - id가 일치하면 해당 Product 반환
    - 못 찾으면 null 반환

3. `public Product[] searchProductsByName(String keyword)`
    - 임시 배열 생성 (크기 productCount)
    - 상품명에 keyword가 포함되면 임시 배열에 추가
    - 결과 개수만큼 새 배열 생성하여 반환
    - 힌트: `name.toLowerCase().contains(keyword.toLowerCase())`

4. `public Product[] searchProductsByCategory(String category)`
    - searchProductsByName과 유사
    - 카테고리가 일치하는 상품 찾기
    - 힌트: `category.equalsIgnoreCase(keyword)`

5. `public void printAllProducts()`
    - 반복문으로 모든 상품 출력
    - 형식: "번호. [ID] 상품명 - 가격원 (재고: N개)"
    - 예시: `System.out.println((i+1) + ". [" + p.getId() + "] " + p.getName() + " - " + p.getPrice() + "원 (재고: " + p.getStock() + "개)");`

**주문 관리 메서드:**

1. `public Order createOrder()`
    - 새 Order 객체 생성
    - 생성 메시지 출력
    - Order 반환

2. `public void addOrderItem(Order order, String productId, int quantity)`
    - findProductById()로 상품 찾기
    - 상품이 없으면 에러 메시지 출력 후 return
    - isAvailable()로 재고 확인
    - 재고 부족시 에러 메시지 출력 후 return
    - order.addItem() 호출
    - 추가 완료 메시지 출력

3. `public void processOrder(Order order)`
    - order.calculateTotal(this) 호출
    - 주문 내역 출력 (상품명, 수량, 금액)
    - 반복문으로 재고 차감 (product.decreaseStock())
    - order.complete() 호출
    - orders 배열에 추가
    - 결제 완료 메시지 출력

4. `public Order findOrderById(String orderId)`
    - 반복문으로 orders 배열 순회
    - orderId가 일치하면 반환
    - 못 찾으면 null 반환

5. `public void printAllOrders()`
    - 반복문으로 모든 주문 출력
    - 형식: "번호. [주문ID] 총금액원 (상태)"
    - 예시: `System.out.println((i+1) + ". [" + order.getOrderId() + "] " + order.getTotalAmount() + "원 (" + order.getStatus() + ")");`


---

### 5. ShopApp.java (메인)

**패키지:** `com.shop`

**역할:** 프로그램 실행 및 시나리오 테스트

**main 메서드 구조:**
```java
public static void main(String[] args) {
    // ShopManager 생성
    // 4가지 시나리오 실행
}
```

**시나리오 (4개):**

**1. 초기 데이터 설정**
```java
System.out.println(">>> 시나리오 1: 초기 데이터 설정\n");

// 상품 3-4개 생성
Product product1 = new Product("노트북", 1500000, 5, "전자기기");
Product product2 = new Product("마우스", 30000, 20, "전자기기");
Product product3 = new Product("Java책", 35000, 10, "도서");
Product product4 = new Product("키보드", 80000, 15, "전자기기");

// 매니저에 등록
manager.addProduct(product1);
manager.addProduct(product2);
manager.addProduct(product3);
manager.addProduct(product4);
```

**2. 상품 조회**
```java
System.out.println(">>> 시나리오 2: 상품 조회\n");

// 전체 상품 출력
manager.printAllProducts();

// 카테고리 검색
System.out.println("\n[검색: 전자기기]");
Product[] electronics = manager.searchProductsByCategory("전자기기");
for (int i = 0; i < electronics.length; i++) {
    Product p = electronics[i];
    System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice() + "원");
}
```

**3. 주문 생성 및 처리**
```java
System.out.println(">>> 시나리오 3: 주문 생성 및 처리\n");

// 빈 주문 생성
Order order = manager.createOrder();

// 상품 추가 (product1, product2, product4의 getId() 사용)
manager.addOrderItem(order, product1.getId(), 1);
manager.addOrderItem(order, product2.getId(), 2);
manager.addOrderItem(order, product4.getId(), 1);

// 주문 처리 (총액 계산, 재고 차감, 결제 완료)
manager.processOrder(order);
```

**4. 전체 조회**
```java
System.out.println(">>> 시나리오 4: 전체 조회\n");

// 전체 주문 출력
manager.printAllOrders();

// 재고 현황 확인
System.out.println("\n=== 재고 현황 ===");
manager.printAllProducts();
```

## 예상 실행 결과

```
>>> 시나리오 1: 초기 데이터 설정

[상품 등록] 노트북 - 1500000원
[상품 등록] 마우스 - 30000원
[상품 등록] Java책 - 35000원
[상품 등록] 키보드 - 80000원

>>> 시나리오 2: 상품 조회

=== 전체 상품 목록 ===
1. [P1] 노트북 - 1500000원 (재고: 5개)
2. [P2] 마우스 - 30000원 (재고: 20개)
3. [P3] Java책 - 35000원 (재고: 10개)
4. [P4] 키보드 - 80000원 (재고: 15개)

[검색: 전자기기]
1. 노트북 - 1500000원
2. 마우스 - 30000원
3. 키보드 - 80000원

>>> 시나리오 3: 주문 생성 및 처리

[주문 생성] O1

[주문 항목 추가] 노트북 x 1
[주문 항목 추가] 마우스 x 2
[주문 항목 추가] 키보드 x 1

=== 주문 내역 ===
주문번호: O1
----------------------------
노트북 x 1 = 1500000원
마우스 x 2 = 60000원
키보드 x 1 = 80000원
----------------------------
총 금액: 1640000원

[결제 완료] O1

>>> 시나리오 4: 전체 조회

=== 전체 주문 ===
1. [O1] 1640000원 (결제완료)

=== 재고 현황 ===
=== 전체 상품 목록 ===
1. [P1] 노트북 - 1500000원 (재고: 4개)
2. [P2] 마우스 - 30000원 (재고: 18개)
3. [P3] Java책 - 35000원 (재고: 10개)
4. [P4] 키보드 - 80000원 (재고: 14개)

```
