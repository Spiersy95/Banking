package Models;

import Models.AccountMethods;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicAccount implements AccountMethods {
    private int balance;
    private String accountNumber;
    private ArrayList<Customer> customers;

    public BasicAccount(String accountNumber, int balance){
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
