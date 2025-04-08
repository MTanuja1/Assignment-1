import java.util.HashMap;
import java.util.Map;

public class ATM {

   private Map<Integer,Account> accounts=new HashMap<>();
   private Account currentAccount=null;

   public boolean login(int accountNo,String pin){
       Account account=accounts.get(accountNo);
       if(account!=null && account.getPin().equals(pin)){
           currentAccount=account;
           System.out.println("Welcome "+account.getName()+" to atm simulator project:"+ account.getAccountNumber());
           return true;
       }
       return false;
   }

   public double checkBalance(){
       return currentAccount!=null?currentAccount.getBalance():0.0;
   }

   public void deposit(double amount){
       if(currentAccount!=null){
           currentAccount.deposit(amount);
       }
   }
public boolean withdrawl(double amount){
       if(currentAccount!=null && currentAccount.withdraw(amount)){
           return true;
       }
    System.out.println("Insufficient Funds");
     return false;
}

public void createNewAccount(int accountNumber,String pin,String name,double initialBalance){
       Account newAccount=new Account(accountNumber,pin,name,initialBalance);
       accounts.put(accountNumber,newAccount);
    System.out.println("account created successfully!!!");
}
  }





