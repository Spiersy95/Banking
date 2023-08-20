import java.util.ArrayList;

public class BasicAccount implements AccountMethods{
    private int balance;
    private String accountNumber;
    private ArrayList<Customer> customers;

    public BasicAccount(String accountNumber, Customer[] customers, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customers = new ArrayList<>();
        for (int i = 0; i < customers.length; i++){
            this.customers.add(customers[i]);
            customers[i].registerAccount(this);
        }

    }

    @Override
    public void transfer(AccountMethods target, int money) {
        if (money <= balance){
            target.deposit(money);
            balance -= money;
        }
    }
    public int checkBalance(){
        return this.balance;
    }
    public void withdraw(int money){
        if (this.getBalance() >= money){
            balance -= money;
        }
    }
    public void deposit(int money){
        balance += money;
    }
    public int getBalance(){
        return balance;
    }
    public String toString(){
        return accountNumber;
    }



}
