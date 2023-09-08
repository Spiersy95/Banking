package Tests;

import BankRunnables.DepositRun;
import BankRunnables.GetBalanceRun;
import BankRunnables.WithdrawRun;
import Models.BasicAccount;
import Models.Customer;

public class GetBalanceTest {

    public static void main(String[] args)  {

        BasicAccount bs1 = new BasicAccount("001", 5000);
        Customer scott = new Customer("Scott");
        Customer elly = new Customer("elly");

        scott.openAccount(bs1);
        elly.openAccount(bs1);

        GetBalanceRun r1 = new GetBalanceRun(scott, bs1);
        WithdrawRun r2 = new WithdrawRun(scott, bs1, 500);
        DepositRun r3 = new DepositRun(scott, bs1 , 500);

        Thread t1 = new Thread(r3);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r2);

        t1.start();
        t2.start();
        t3.start();


    }
}
