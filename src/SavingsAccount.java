import java.util.ArrayList;

public class SavingsAccount implements AccountMethods {
    private int balance;
    private String accountNumber;
    private ArrayList<Customer> customers;

    public SavingsAccount(String accountNumber, Customer[] customers, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        for (int i = 0; i < customers.length; i++){
            this.customers.add(customers[i]);
        }
    }

    @Override
    public void transfer(AccountMethods target, int money) {
        //add code to allow transfer between accounts
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
    public String getAccountNumber(){
        return accountNumber;
    }
    public int getBalance(){
        return balance;
    }
}
