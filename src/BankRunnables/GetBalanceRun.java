package BankRunnables;

import Models.Customer;
import Models.AccountMethods;
public class GetBalanceRun implements Runnable{

    private Customer customer;
    private AccountMethods account;
    public GetBalanceRun(Customer customer, AccountMethods account){
        this.customer = customer;
        this.account = account;
    }

    public void run(){
        customer.getBalance(account);
        Thread.sleep(1);
    }

}