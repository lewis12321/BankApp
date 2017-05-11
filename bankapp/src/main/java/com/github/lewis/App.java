package com.github.lewis;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private static int accountNumber;

    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello, Welcome to the Bank." );
        System.out.println("Would you like to do?");
        System.out.println("1. Create account");

        String[] account = createAccount();
        saveAccount(args[0], account);
    }

    public static void saveAccount(String fileLocation, String[] account) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation));

        writer.writeNext(account);
        writer.flush();
        writer.close();
    }

    private static String[] createAccount() {
        String[] account = new String[3];
        account[0] = Integer.toString(createAccountNumber());
        account[1] = createPassword();
        account[2] = "0";
        return account;
    }

    public static int createAccountNumber(){
        return accountNumber++;
    }

    public static String createPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your desired password.");
        return scanner.nextLine();
    }
}
