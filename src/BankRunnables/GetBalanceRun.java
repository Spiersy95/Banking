package BankRunnables;

import Models.Customer;
import Models.AccountMethods;
public class GetBalanceRun implements Runnable {

    private Customer customer;
    private AccountMethods account;

    public GetBalanceRun(Customer customer, AccountMethods account) {
        this.customer = customer;
        this.account = account;
    }

    public void run() {
        try{ Thread.sleep(1);
            customer.getBalance(account);
            //sleep is to force computer to do two actions at the same time to test the locks.
        } catch (InterruptedException e){
            System.out.println("Sorry this thread was interrupted");
        }


    }


}