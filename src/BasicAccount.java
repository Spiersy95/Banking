import java.util.ArrayList;
import java.util.Arrays;

public class BasicAccount implements AccountMethods{
    private int balance;
    private String accountNumber;
    private ArrayList<Customer> customers;

    public BasicAccount(String accountNumber, Customer[] customers, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customers = new ArrayList<>();
        this.customers.addAll(Arrays.asList(customers));

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
