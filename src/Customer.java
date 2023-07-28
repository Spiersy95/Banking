import java.util.ArrayList;

;

public class Customer {
    private String name;
    private ArrayList<AccountMethods> accountsArray;


    public Customer(String name, AccountMethods[] accountsList){
        this.name = name;
        accountsArray = new ArrayList<AccountMethods>();
                for (int i = 0; i < accountsList.length; i++){
                    accountsArray.add(accountsList[i]);
        }
    }

}
