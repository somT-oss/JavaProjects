import java.util.Arrays;
import java.util.Scanner;

public class BMS {

    /* This is a BANK MANAGEMENT SYSTEM TERMINAL APP coded in Java*/
    /* The aim of this bank app is to facilitate the easy transaction of money through users*/

    public static void main(String[] args) {

        // This block of code here collects user input to create a User from the user constructor explained below.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your username: ");
        System.out.println();
        String userHolderName = userInput.nextLine();


        System.out.println("Enter your account number: ");
        System.out.println();
        String accountNumber = userInput.nextLine();

        if (accountNumber.length() < 11 && accountNumber.length() > 11) {
            System.out.println("Invalid account number");
        }
        int userAccountNumber = Integer.parseInt(accountNumber);

        System.out.println("Enter your account balance: ");
        System.out.println();
        String accountBalance = userInput.nextLine();
        Float userAccountBalance = Float.parseFloat(accountBalance);

        // This creates a user instance from the user inputs gathered from above
        User firstUser = new User(userHolderName, userAccountBalance, userAccountNumber);
        System.out.println("First user account details: ");
        System.out.println(firstUser.userHolderName);
        System.out.println(firstUser.userAccountNumber);
        System.out.println(firstUser.userAccountBalance);


        // This is a static user created by manually entering the essential information for creating a second user
        User secondUser = new User("Jude", 0.00F, 1211232322);
        System.out.println("Second user account details: ");
        System.out.println(secondUser.userHolderName);
        System.out.println(secondUser.userAccountNumber);
        System.out.println(secondUser.userAccountBalance);


        // Here we add each users account number to an array so we can crosscheck whether the user account number is true before sending money
        int[] userAccountNumbers = new int[3];
        userAccountNumbers[0] = firstUser.userAccountNumber;
        userAccountNumbers[1] = secondUser.userAccountNumber;

        // This prints out the list of user account numbers being added.
        System.out.println(Arrays.toString(userAccountNumbers));
        
        // This is for calling the sendMoney method defined below
        String sendMoney = sendMoney(firstUser.userAccountBalance, userAccountNumbers);
        System.out.println(sendMoney);

    }

    // This is the sendMoney method that handles all the logic for sending money
    public static String sendMoney(Float userAccountBalance, int[] userAccountNumbers) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount you want to send: ");
        String moneyToSendString = scanner.nextLine();
        Float moneyToSend = Float.parseFloat(moneyToSendString);

        System.out.println("Enter destination account: ");
        String destinationAccountString = scanner.nextLine();
        int destinationAccount = Integer.parseInt(destinationAccountString);

        for ( int account : userAccountNumbers) {

            System.out.println(account);
            
            if (destinationAccount != account && moneyToSend > userAccountBalance) {
                return "Invalid Transaction.";
            } else {
                return "Transfer successfully.";
            }
       }

        return "You have used the transfer method";
    }

    // This is block of code that handles creation of new users
    static class User {
        String userHolderName;
        Float  userAccountBalance;
        int    userAccountNumber;

        User(String userHolderName, Float userAccountBalance, int userAccountNumber) {
            this.userHolderName = userHolderName;
            this.userAccountBalance = userAccountBalance;
            this.userAccountNumber = userAccountNumber; 
        }
    }
}