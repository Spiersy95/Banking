package Models;

import Models.AccountMethods;
import Models.Customer;

import java.util.ArrayList;

public class SavingsAccount implements AccountMethods {
    private int balance;
    private String accountNumber;
    private ArrayList<Customer> customers;

    public SavingsAccount(String accountNumber, Customer[] customers, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void transfer(AccountMethods target, int money) {
        if (money <= balance){
            target.deposit(money);
            this.withdraw(money);
        }
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
