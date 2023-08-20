import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Customer {
    private String name;
    private ReentrantLock accountLock;
    private Condition enoughFunds;



    public Customer(String name){
        this.name = name;
        accountLock = new ReentrantLock();
        enoughFunds = accountLock.newCondition();

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

    public void transfer(AccountMethods source, AccountMethods target, int money){
        accountLock.lock();
        try{
            if (money > source.getBalance()){
                source.withdraw(money);
                target.deposit(money);
            } else {
                System.out.println("Sorry this account does not have the funds for a transfer");
            }
        }  finally {
            enoughFunds.signalAll();
            accountLock.unlock();
        }

    }


    }

