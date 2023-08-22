import Models.Customer;
import Models.AccountMethods;
public class getBalanceRun implements Runnable{

    private Customer customer;
    private AccountMethods account;
    public getBalanceRun(Customer customer, AccountMethods account){
        this.customer = customer;
        this.account = account;
    }

    public void run(){
        customer.getBalance(account);
    }

    public static void main(String[] args) {

    }
}