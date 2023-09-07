package Models;

import Models.AccountMethods;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Customer {
    private String name;
    private ReentrantLock accountLock;
    private Condition enoughFunds;
    private ArrayList<AccountMethods> accountList;



    public Customer(String name){
        this.name = name;
        accountLock = new ReentrantLock();
        enoughFunds = accountLock.newCondition();
        accountList = new ArrayList<>(3);
    }

    public void deposit(AccountMethods account, int money){
        accountLock.lock();
        try {
            account.deposit(money);
        } finally{
            enoughFunds.signalAll();
            accountLock.unlock();
        }
    }
    public void withdraw(AccountMethods account, int money){
        boolean waiting = true;
        accountLock.lock();
        try{if (this.accountList.contains(account)){
            while (money > account.getBalance()){
                if (!waiting){
                    Thread.currentThread().interrupt();
                }
                waiting = enoughFunds.await(1,TimeUnit.SECONDS);
            }
            System.out.println("Withdraw Thread: Balance at the beginning of thread: " + account.getBalance());
            account.withdraw(money);
            System.out.println("Withdraw Thread: Attempting to withdraw "+ money);
            System.out.println("Withdraw Thread: Balance at the end of thread: " + account.getBalance());
        } else {
            System.out.println("You are not associated with this account");
        }

        } catch (InterruptedException e){
            System.out.println("Sorry the withdrawal took to long and we cannot wait any longer");
        } finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }

        }

    public void transfer(AccountMethods source, AccountMethods target, int money){
        accountLock.lock();
        try{
            if (money > source.getBalance() && this.accountList.contains(source)){
                source.withdraw(money);
                target.deposit(money);
            }
            if (!this.accountList.contains(source)){
                System.out.println("Sorry you are not associated with this account");
            } else {
                System.out.println("sorry you do not have the funds for this");
            }
        }  finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }

    }
    public void getBalance(AccountMethods account){
        accountLock.lock();
        try{ if (this.accountList.contains(account)){
            account.getBalance();
        } else {
            System.out.println("You are not authorized to see this account");
        }
        } finally {
            enoughFunds.signalAll();
            accountLock.lock();
        }

    }
    public void openAccount(AccountMethods account){
        if (!this.accountList.contains(account) && this.accountList.size() < 3) {
            this.accountList.add(account);
        }
        if (this.accountList.size() >= 3){
            System.out.println("Sorry You already have the maximum number of accounts with us");
        }
        if (this.accountList.contains(account)){
            System.out.println("You have already opened this account");
        }

    }

    public void closeAccount(AccountMethods account){
        if (this.accountList.contains(account)){
            this.accountList.remove(account);
        } else {
            System.out.println("Sorry you are not associated with this account");
        }
    }
    }

