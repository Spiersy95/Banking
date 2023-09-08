package Tests;

import BankRunnables.TransferRun;
import BankRunnables.WithdrawRun;
import Models.BasicAccount;
import Models.Customer;

public class TransferAndWithdrawTest {

    public static void main(String[] args){

        BasicAccount bs1 = new BasicAccount("001", 5000);
        BasicAccount bs2 = new BasicAccount("002", 5000);
        Customer scott = new Customer("Scott");
        Customer elly = new Customer("elly");
        scott.openAccount(bs1);
        elly.openAccount(bs1);
        elly.openAccount(bs2);

        TransferRun r1 = new TransferRun(scott, bs1, bs2, 5000);
        WithdrawRun r2 = new WithdrawRun(elly, bs1,4);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
