package BankRunnables;

import Models.AccountMethods;
import Models.Customer;

public class DepositRun implements Runnable{

    private Customer customer;
    private AccountMethods account;
    private int money;

    public DepositRun(Customer customer, AccountMethods account, int money){
        this.customer = customer;
        this.account = account;
        this.money = money;
    }

    public void run(){
        customer.deposit(account, money);
    }
}
