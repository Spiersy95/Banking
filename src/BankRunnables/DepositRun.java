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
        try{
            customer.deposit(account, money);
            Thread.sleep(2);
            //sleep is to force computer to do two actions at the same time to test the locks.
        } catch (InterruptedException e){
            System.out.println("Sorry something went wrong");
        }
    }
}
