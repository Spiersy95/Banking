public interface AccountMethods {
    int checkBalance();
    void transfer(String target);
    void withdraw(int money);
    void deposit(int money);
    void setAccountNumber(String accountNumber);
    void getAccountNumber();


}
