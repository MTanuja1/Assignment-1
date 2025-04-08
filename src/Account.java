public class Account {
     private int accountNumber;
     private String Pin;
     private String Name;
     private double Balance;



    public Account(int accountNumber, String pin, String name, double balance) {
        this.accountNumber = accountNumber;
        Pin = pin;
        Name=name;
        Balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public void deposit(double amount){
        if(amount>0){
            Balance+=amount;
            System.out.println("Deposit successful");
        }else{
            System.out.println("Invalid deposit");
        }
    }
    public boolean withdraw(double amount) {
        if (amount <= Balance){
            Balance-=amount;
            System.out.println("withdraw successfully");
            return true;
        }
        return false;
    }
}
