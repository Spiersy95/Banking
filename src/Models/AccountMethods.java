package Models;

public interface AccountMethods {
    int getBalance();
    void transfer(AccountMethods target, int money);
    void withdraw(int money);
    void deposit(int money);





}
