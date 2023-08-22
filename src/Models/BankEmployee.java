package Models;

import java.util.Random;
public class BankEmployee {

    public BankEmployee(){

    }
    public BasicAccount createBasicAccount(String accountNumber, Customer[] customers, int money){
        return new BasicAccount(accountNumber, customers, money);

    }
    public SavingsAccount createSavingsAccount(String accountNumber, Customer[] customers, int money){
        return new SavingsAccount(accountNumber, customers, money);

    }

}
