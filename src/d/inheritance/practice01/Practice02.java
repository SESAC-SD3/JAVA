package d.inheritance.practice01;

class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println(amount + "입금됨");
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(amount + "출금됨");
        } else {
            System.out.println("잔액부족");
        }
    }
}

class SavingsAccount extends Account{
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("이자" + interest + "가 추가됨");
    }
}

class CheckingAccount extends Account{
    double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("출글불가");
        }
    }
}

public class Practice02 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA001", 1000000, 0.03);
        savings.deposit(500000);
        savings.addInterest();
        System.out.println("저축예금 잔액: " + savings.balance);

        CheckingAccount checking = new CheckingAccount("CA001", 100000, 500000);
        checking.withdraw(400000);
        System.out.println("입출금예금 잔액: " + checking.balance);
    }
}
