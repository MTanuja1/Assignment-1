package ATM;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static  int counter=1;
    private final String name;
    private final String userId;
    private final String pin;
    private final List<Account> accountsList=new ArrayList<>();

    public User(String name, String pin) {
        this.name = name;
        this.userId=generateUserId();
        this.pin = pin;
    }

    public String generateUserId(){
        return "ATM.User"+String.format("%03d",counter++);
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }
    public  void addAccounts(Account account){
        accountsList.add(account);
    }
}
