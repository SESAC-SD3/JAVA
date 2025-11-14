package h.exception;


class InsufficientBalanceException extends RuntimeException {
    private int current;
    private int request;

    public InsufficientBalanceException(int current, int request) {
        super("잔액부족" + current + " / " + request);
        this.current = current;
        this.request = request;
    }
}


public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (balance < amount){
            throw new InsufficientBalanceException(balance, amount);
        }
        balance = balance - amount;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000);
        try {
            ba.withdraw(100000);
        } catch (InsufficientBalanceException e){
            System.out.println("problem");
        }
        System.out.println(ba.balance);
    }
}
