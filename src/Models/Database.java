package Models;

import Models.AccountMethods;

import java.util.ArrayList;

public class Database {
    private static ArrayList<AccountMethods> accounts = new ArrayList<AccountMethods>();

    public static void addAccount(AccountMethods e){
        accounts.add(e);
    }




}
