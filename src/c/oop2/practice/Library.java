package c.oop2.practice;

public class Library {
    // TODO: 필드 선언
    // - books (Book[]): 책 배열
    // - bookCount (int): 현재 책의 개수
    Book[] books;
    int bookCount;

    // TODO: 생성자
    // Library(int capacity)
    // - books 배열을 capacity 크기로 생성
    // - bookCount를 0으로 초기화
    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    // TODO: addBook(Book book) 메서드
    // - books 배열에 book 추가
    // - bookCount 증가
    // - 배열이 가득 차면 "더 이상 책을 추가할 수 없습니다." 출력
    public void addBook(Book book) {
        if (bookCount >= books.length) {
            System.out.println("책추가 불가");
            return;
        }
        books[bookCount] = book;
        bookCount++;
    }

    // TODO: addBook(String title, String author) 메서드 오버로딩
    // - Book 객체를 생성하여 addBook(Book) 호출
    public void addBook(String title, String author) {
        //Book b = new Book(title, author);
        //addBook(b);
        addBook(new Book(title, author));
    }

    // TODO: addBook(String title, String author, int price) 메서드 오버로딩
    // - Book 객체를 생성하여 addBook(Book) 호출
    public void addBook(String title, String author, int price) {
        addBook(new Book(title, author, price));
    }

    // TODO: displayAllBooks() 메서드
    // - 모든 책의 정보를 출력 (번호 포함)
    // - 형식: "1. 제목 - 저자: 저자명, 가격: 0000원"
    public void displayAllBooks() {
        for (int i = 0; i < bookCount; i++) {
            books[i].displayInfo();
        }
    }

    // TODO: searchByTitle(String keyword) 메서드
    // - 제목에 keyword가 포함된 책을 모두 출력
    // - 대소문자 구분 없이 검색 (toLowerCase() 사용)
    public void searchByTitle(String keyword) {
        for (int i = 0; i < bookCount; i++) {
            boolean check = books[i].getTitle().toLowerCase().contains(keyword.toLowerCase());

            if (check) {
                books[i].displayInfo();
            }
        }
    }

    // TODO: searchByAuthor(String keyword) 메서드
    // - 저자명에 keyword가 포함된 책을 모두 출력
    public void searchByAuthor(String keyword) {
        for (int i = 0; i < bookCount; i++) {
            boolean check = books[i].getAuthor().toLowerCase().contains(keyword.toLowerCase());
            if (check) {
                books[i].displayInfo();
            }
        }
    }

    // TODO: getTotalPrice() 메서드
    // - 모든 책 가격의 합계 반환
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < bookCount; i++) {
            total += books[i].getPrice();
        }
        return total;
    }

    // TODO: getAveragePrice() 메서드
    // - 평균 가격 반환
    // - 책이 없으면 0 반환
    public int getAveragePrice() {
        if (bookCount == 0) {
            return 0;
        }
        return getTotalPrice() / bookCount;
    }

    // TODO: getBookCount() 메서드
    // - 현재 책의 개수 반환
    public int getBookCount() {
        return bookCount;
    }

    // TODO: applyDiscountToAll(int percent) 메서드
    // - 모든 책에 percent% 할인 적용
    public void applyDiscountToAll(int percent) {
        for (int i = 0; i < bookCount; i++) {
            books[i].applyDiscount(percent);
        }
    }
}