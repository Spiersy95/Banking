package Models;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class Customer {
    private String name;
    private ArrayList<AccountMethods> accountList;
    private final ReentrantLock customerLock = new ReentrantLock();



    public Customer(String name){
        this.name = name;
        accountList = new ArrayList<>(3);
    }

    public void deposit(AccountMethods account, int money){
        customerLock.lock();
        try{
            System.out.println("Deposit Thread: Money in Account " + account + " at the start of thread: " + account.getBalance());
            account.deposit(money);
            System.out.println("Deposit Thread: Attempting to deposit " + money + " into account " + account);
            System.out.println("Deposit Thread: Money in Account " + account + " at the end of thread: " + account.getBalance());
        } finally {
            customerLock.unlock();
        }
    }
    public void withdraw(AccountMethods account, int money){
        customerLock.lock();
        try{
            if (this.accountList.contains(account)){
                System.out.println("Withdraw Thread: Balance at the beginning of thread: " + account.getBalance());
                account.withdraw(money);
                System.out.println("Withdraw Thread: Attempting to withdraw "+ money + " from Account " + account);
                System.out.println("Withdraw Thread: Balance at the end of thread: " + account.getBalance());
            } else {
                System.out.println("You are not associated with this account");
            }
        } finally {
            customerLock.unlock();
        }
    }

    public void transfer(AccountMethods source, AccountMethods target, int money) {
        customerLock.lock();
        try {
            if (!this.accountList.contains(source)) {
                System.out.println("Sorry you are not associated with this account");
            } else if (money > source.getBalance()) {
                System.out.println("sorry you do not have the funds for this");
            }
            if (money <= source.getBalance() && this.accountList.contains(source)) {
                source.transfer(target, money);
            }
        } finally {
            customerLock.unlock();
        }
    }
    public Integer getBalance(AccountMethods account){
        customerLock.lock();
        try{
            if (this.accountList.contains(account)){
                System.out.println("The balance of account " + account + " is " + account.getBalance());
                return account.getBalance();
            } else {
                System.out.println("You are not authorized to see this account");
                return null;
            }
        } finally {
            customerLock.unlock();
        }
    }
    public void openAccount(AccountMethods account){
        if (this.accountList.size() >= 3){
            System.out.println("Sorry You already have the maximum number of accounts with us");
        }
        if (this.accountList.contains(account)){
            System.out.println("You have already opened this account");
        }
        if (!this.accountList.contains(account) && this.accountList.size() < 3) {
            this.accountList.add(account);
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

