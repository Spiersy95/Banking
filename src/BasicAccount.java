public class BasicAccount implements AccountMethods{
    private int balance;
    private String accountNumber;

    public BasicAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    @Override
    public void transfer(AccountMethods target, int money) {
    //add code to allow transfer between accounts
    }
    public int checkBalance(){
        return this.balance;
    }
    public void withdraw(int money){
        if (this.getBalance() >= money){
            balance -= money;
        }
    }
    public void deposit(int money){
        balance += money;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public int getBalance(){
        return balance;
    }


}
