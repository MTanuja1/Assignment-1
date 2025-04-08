import java.util.ArrayList;
import java.util.List;

public class User {
    private static  int counter=1;
    private String name;
    private  String userId;
    private String pin;
    private List<Account> accountsList=new ArrayList<>();

    public User(String name, String pin) {
        this.name = name;
        this.userId=generateUserId();
        this.pin = pin;
    }

    public String generateUserId(){
        return "User"+String.format("%03d",counter++);
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
