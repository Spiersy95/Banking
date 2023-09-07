package Models;

import Models.AccountMethods;

import java.util.ArrayList;

public class Database {
    private static ArrayList<AccountMethods> accounts = new ArrayList<AccountMethods>();

    public static void addAccount(AccountMethods e){
        accounts.add(e);
    }}

    /*Plan to implement different types of accounts and hold everything in a database and implement
        differing interest rates on each account
     */

