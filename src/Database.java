import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Database {
    private static ArrayList<AccountMethods> accounts = new ArrayList<AccountMethods>();

    public static void addAccount(AccountMethods e){
        accounts.add(e);
    }




}
