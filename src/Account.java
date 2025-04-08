public class Account {
     private static int counter=1;
     private int accountNumber;
     private double Balance;



    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        Balance = balance;
    }





    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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
