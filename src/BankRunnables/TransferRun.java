package BankRunnables;

import Models.AccountMethods;
import Models.Customer;

public class TransferRun implements Runnable {

    private Customer customer;

    private AccountMethods source;
    private AccountMethods target;
    private int money;

    public TransferRun(Customer customer, AccountMethods source, AccountMethods target, int money){
        this.customer = customer;
        this.source = source;
        this.target = target;
        this.money = money;
    }
    public void run(){
        customer.transfer(source, target, money);
        Thread.sleep(1);
        //sleep is to force computer to do two actions at the same time to test the locks.
    }


}
