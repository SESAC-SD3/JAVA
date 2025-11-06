package c.oop2.practice;

public class Book {
    // TODO: 필드 선언
    String title;
    String author;
    int price;
    String isbn;

    // TODO: 생성자 오버로딩 (this()를 사용하여 연결)
    // 1. Book(String title, String author)
    public Book(String title, String author) {
        this(title, author, 0, null);
    }

    // 2. Book(String title, String author, int price)
    public Book(String title, String author, int price) {
        this(title, author, price, null);
    }

    // 3. Book(String title, String author, int price, String isbn)
    public Book(String title, String author, int price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    // TODO: displayInfo() 메서드
    // 출력 형식: "제목 - 저자: 저자명, 가격: 0000원"
    public void displayInfo() {
        displayInfo(false);
    }

    // TODO: displayInfo(boolean detailed) 메서드 오버로딩
    public void displayInfo(boolean detailed) {
        System.out.println(title + author + price);
        if (detailed && isbn != null) {
            System.out.println(isbn);
        }
    }

    // TODO: applyDiscount(int percent) 메서드
    // percent% 할인 적용 (예: 10 입력 시 10% 할인)
    public void applyDiscount(int percent) {
        price = price * (100 - percent) / 100;
    }

    // TODO: applyDiscount(int amount, boolean isPercent) 메서드 오버로딩
    // isPercent가 true면 퍼센트 할인, false면 정액 할인
    public void applyDiscount(int amount, boolean isPercent) {
        if (isPercent) {
            applyDiscount(amount);
        } else {
            price = price - amount;
        }
    }

    // TODO: getTitle() 메서드
    public String getTitle() {
        return title;
    }

    // TODO: getAuthor() 메서드
    public String getAuthor() {
        return author;
    }

    // TODO: getPrice() 메서드
    public int getPrice() {
        return price;
    }
}