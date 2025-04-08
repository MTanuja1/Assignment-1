import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATM {

   private Map<String,User> users=new HashMap<>();
   private Account currentAccount=null;

   public boolean login(String userId, String pin, Scanner sc){
       User user=users.get(userId);
       if(user!=null && user.getPin().equalsIgnoreCase(pin)){
           System.out.println(userId+" have successfully logged in ");
           List<Account> accountList=user.getAccountsList();
           if(accountList.isEmpty()){
               System.out.println("No accounts found for this user.");
               return false;
           }
           System.out.println("Select an account");
           for(int i=0;i<accountList.size();i++){
               System.out.println((i+1)+".Account No."+accountList.get(i).getAccountNumber());

           }
           int choice=sc.nextInt();
           if(choice>=1 && choice<=accountList.size()){
               currentAccount=accountList.get(choice-1);
               return true;
           }else{
               System.out.println("Invalid account ");
           }
       }else{
           System.out.println("Invalid userID and user pin");
       }
      return  false;
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

public void createNewUser(String name,int accountNumber,String pin,double initialBalance) {
    for (User user : users.values()) {
       for(Account account: user.getAccountsList()){
           if(user.getName().equalsIgnoreCase(name) && account.getAccountNumber()==accountNumber){
               System.out.println("Account already exists!!!");
               return;
           }else if(account.getAccountNumber()!=accountNumber){
               Account account1=new Account(accountNumber,initialBalance);
               user.addAccounts(account1);
               System.out.println("New account added to existing user "+ name+ " with account number "+accountNumber);
               return;
           }
       }
    }

    User newUser=new User(name,pin);
    Account newAccount=new Account(accountNumber,initialBalance);
    newUser.addAccounts(newAccount);
    users.put(newUser.getUserId(), newUser);
    System.out.println("Account created successfully for user "+newUser.getName()+" with userId: "+newUser.getUserId());
}}








