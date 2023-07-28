public class BasicAccount implements AccountMethods{
    private int balance;
    private String accountNumber;

    public BasicAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;

    }
}
