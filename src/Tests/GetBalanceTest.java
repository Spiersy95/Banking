package Tests;

import BankRunnables.GetBalanceRun;
import Models.BasicAccount;
import Models.Customer;

public class GetBalanceTest {

    public static void main(String[] args){

        BasicAccount bs1 = new BasicAccount("001", 5000);
        Customer scott = new Customer("Scott");
        Customer elly = new Customer("elly");
        GetBalanceRun r1 = new GetBalanceRun(scott, bs1);
        GetBalanceRun r2 = new GetBalanceRun(elly, bs1);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();


    }
}
