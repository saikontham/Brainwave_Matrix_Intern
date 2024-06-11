package atm;

import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner in;


    public ATM() {
        this.balance =0;
        this.in = new Scanner(System.in);
    }

    private void menu() {
        while (true) {
            System.out.println("Welcome User..!");
            System.out.println("Select Your Choice From Below.");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit Amount");
            System.out.println("3.Withdraw Amount");
            System.out.println("4.Exit");

            System.out.println("Enter Your Choice For Specific Action");
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3:
                    withdrawAmount();
                    break;
                case 4:
                    exitService();
                    break;
                default:
                    System.out.println("Enter Valid Choice From Above");

            }
        }
    }
    private int getUserChoice() {
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            in.next();
        }
        return in.nextInt();
    }
    private double getValidAmount() {
        while (!in.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            in.next();
        }
        return in.nextDouble();
    }
    private  void exitService() {
        System.out.println("ThankYou For Using Our ATM Service");
        in.close();
        System.exit(0);
    }

    private void withdrawAmount() {
        System.out.println("Enter Amount To Withdraw");
        double amount=getValidAmount();
        if (balance > 0 && amount<=balance) {
            balance-=amount;
            System.out.println("SuccessFully Withdrawn Amount "+amount);
        } else if (balance==0) {

            System.out.println("Sorry... Deposit Amount First");

        } else {
            System.out.println("Enter an Valid Amount or Insufficient Amount to withdraw");
        }
    }

    private  void depositAmount() {
        System.out.println("Enter the amount to deposit");
        double amount=getValidAmount();
        if (amount>0)
        {
            balance+=amount;
            System.out.println("Amount Deposited Successfully");
        }
        else {
            System.out.println("Invalid Amount Please ReTry Again");
        }
    }

    private void checkBalance() {
        System.out.println("The Balance Of Your Account is: " + this.balance);
    }


    public static void main(String[] args) {
        ATM atm=new ATM();
        atm.menu();
    }
}
