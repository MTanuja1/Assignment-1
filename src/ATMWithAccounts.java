import java.util.Scanner;

public class ATMWithAccounts {
    public static void main(String[] args) {
        ATM atm=new ATM();
        try(Scanner sc=new Scanner(System.in)){
            int choice;
            while(true){

                System.out.println("welcome to Atm Simulator");
                System.out.println("1.create Account");
                System.out.println("2.Login");
                System.out.println("3.Exit");
                choice=sc.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("Enter name:");
                        String name=sc.next();
                        sc.nextLine();
                        System.out.println("Enter account number");
                        int accountNo = sc.nextInt();
                        System.out.println("Enter Pin No.");
                        String pin = sc.next();
                        System.out.println("Enter initial Balance $");
                        double amount = sc.nextDouble();
                        atm.createNewAccount(accountNo,pin,name,amount);
                        break;
                    case 2:
                        System.out.println("Enter Account number");
                        int accNo = sc.nextInt();
                        System.out.println("Enter Pin");
                        String pinNo = sc.next();
                        if(atm.login(accNo,pinNo)){
                        int ch;
                        do {
                            System.out.println("welcome to the simple ATM");
                            System.out.println("1.check Balance");
                            System.out.println("2.Deposit");
                            System.out.println("3.Withdraw");
                            System.out.println("4.Exit");
                            System.out.println("choose an option: ");
                            ch = sc.nextInt();
                            switch (ch) {
                                case 1:
                                    System.out.println("current balance is:  " + atm.checkBalance());
                                    break;
                                case 2:
                                    System.out.println("Enter deposit amount");
                                    double amount1 = sc.nextInt();
                                    atm.deposit(amount1);
                                    break;
                                case 3:
                                    System.out.println("Enter withdrawl amount:$");
                                    double withdrawAmount = sc.nextDouble();
                                    atm.withdrawl(withdrawAmount);
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println();
                            }
                            System.out.println();
                        } while (ch != 4);
                }else{
                    System.out.println("Invalid Account info or pin");
                }
                break;
                    case 3:
                        System.out.println("GoodBye!!! please visit again");
                        return;
                    default:
                        System.out.println("invalid option");
                }


        }} catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }

        }
    }

