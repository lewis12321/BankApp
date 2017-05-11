package com.github.lewis;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Fraser on 11/05/2017.
 */
public class AccountCreator {

    private static int accountNumber;

    public static void saveAccount(String fileLocation, String[] account) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation, true));

        writer.writeNext(account);
        writer.flush();
        writer.close();
    }

    public static String[] createAccount() throws IOException {
        String[] account = new String[3];
        account[0] = Integer.toString(createAccountNumber());
        account[1] = createPassword();
        account[2] = "0";
        return account;
    }

    public static int createAccountNumber() throws IOException {
        int numOfAccounts = AccountUtilises.numberOfAccounts(AccountUtilises.readFromCSV("C:\\Users\\Fraser\\IdeaProjects\\BankApp\\bankapp\\Accounts\\accounts.csv"));
        accountNumber = numOfAccounts;
        return accountNumber++;
    }

    public static String createPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your desired password.");
        return scanner.nextLine();
    }
}
