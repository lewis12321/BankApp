package com.github.lewis;

import java.util.Scanner;

public class Input {

    private Scanner scan = new Scanner(System.in);

    public String createPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your desired password.");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("What is your password?");
        return scan.next();
    }

    String getAccountNumber() {
        System.out.println("What is your account number?");
        return scan.next();
    }

    String getOption(){
        System.out.println( "Hello, Welcome to the Bank." );
        System.out.println("Would you like to do?");
        System.out.println("1. Create account.");
        System.out.println("2. Login to account.");

        return scan.next();
    }

    String getBankManagerOption(){
        System.out.println("Would you like to do?");
        System.out.println("1. Deposit funds.");
        System.out.println("2. Withdraw funds.");

        return scan.next();
    }

    String getDepositAmount(){
        System.out.println("How much would you like to deposit?");
        return scan.next();
    }

    String getWithdrawalAmount(){
        System.out.println("How much would you like to withdraw?");
        return scan.next();
    }

}
