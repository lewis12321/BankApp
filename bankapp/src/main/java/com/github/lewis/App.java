package com.github.lewis;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main( String[] args ) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println( "Hello, Welcome to the Bank." );
        System.out.println("Would you like to do?");
        System.out.println("1. Create account");
        System.out.println("2. Login to account");
        String response = scan.next();

        if (response.equals("1")){
            String[] account = AccountCreator.createAccount();
            AccountCreator.saveAccount("C:\\Users\\Fraser\\IdeaProjects\\BankApp\\bankapp\\Accounts\\accounts.csv", account);
        }else if (response.equals("2")){

        }else{

        }



    }

}
