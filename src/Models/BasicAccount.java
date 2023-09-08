package Models;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BasicAccount implements AccountMethods {
    private int balance;
    private String accountNumber;
    private final static ReentrantLock accountLock = new ReentrantLock();
    private final static Condition enoughFunds = accountLock.newCondition();;

    public BasicAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    @Override
    public void transfer(AccountMethods target, int money) {
        accountLock.lock();
        try {
            this.withdraw(money);
            target.deposit(money);
        } finally {
            accountLock.lock();
        }
    }
    public void withdraw(int money){
        boolean waiting = true;
        accountLock.lock();
        try{
            while (money > this.getBalance()){
                if (!waiting){
                    Thread.currentThread().interrupt();
                }
                waiting = enoughFunds.await(1, TimeUnit.SECONDS);
            }
            this.balance -= money;
        } catch (InterruptedException e){
            System.out.println("Sorry the withdrawal took to long and we cannot wait any longer");
        } finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }
    }
    public void deposit(int money){
        accountLock.lock();
        try {
            this.balance += money;
        } finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }
    }
    public int getBalance(){
        accountLock.lock();
        try{
            return balance;
        } finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }
    }
    public String toString(){
        return accountNumber;
    }
}
