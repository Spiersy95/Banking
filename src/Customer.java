import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Customer {
    private String name;
    private ReentrantLock accountLock;
    private Condition enoughFunds;
    private ArrayList<AccountMethods> accountsArray;


    public Customer(String name){
        this.name = name;
        accountLock = new ReentrantLock();
        enoughFunds = accountLock.newCondition();

    }
    public void registerAccount(AccountMethods account){
        this.accountsArray.add(account);
    }

    public void withdraw(AccountMethods account, int money){
        boolean waiting = true;
        accountLock.lock();
        try{
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
        } catch (InterruptedException e){
            System.out.println("Sorry the withdrawal took to long and we cannot wait any longer");
        } finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }

        }
    }

