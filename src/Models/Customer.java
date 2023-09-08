package Models;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Customer {
    private String name;
    private ArrayList<AccountMethods> accountList;



    public Customer(String name){
        this.name = name;
        accountList = new ArrayList<>(3);
    }

    public void deposit(AccountMethods account, int money){
        account.withdraw(money);
    }
    public void withdraw(AccountMethods account, int money){
        if (this.accountList.contains(account)){
            account.withdraw(money);
        } else {
            System.out.println("You are not associated with this account");
        }
    }

    public void transfer(AccountMethods source, AccountMethods target, int money){
        if (!this.accountList.contains(source)){
            System.out.println("Sorry you are not associated with this account");
        } else if (money > source.getBalance()) {
            System.out.println("sorry you do not have the funds for this");
        }
        if (money <= source.getBalance() && this.accountList.contains(source)){
            source.withdraw(money);
            target.deposit(money);
        }
    }
    public Integer getBalance(AccountMethods account){
        if (this.accountList.contains(account)){
            return account.getBalance();
        } else {
            System.out.println("You are not authorized to see this account");
            return null;
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

