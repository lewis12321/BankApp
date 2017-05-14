package com.github.lewis;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class AccountCreator {

    private final Input input;
    private String fileLocation;

    AccountCreator(Input input, String fileLocation){
        this.input = input;
        this.fileLocation = fileLocation;
    }

    void saveAccount(String[] account) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation, true));

        writer.writeNext(account);
        writer.flush();
        writer.close();
    }

    void overwriteAccount(String[] account) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation));

        writer.writeNext(account);
        writer.flush();
        writer.close();
    }


    String[] createAccount() throws IOException {
        String[] account = new String[3];
        account[0] = Integer.toString(createAccountNumber());
        account[1] = input.createPassword();
        account[2] = "0";
        return account;
    }

    private int createAccountNumber() throws IOException {
        List<String[]> accounts = AccountUtilises.readFromCSV(fileLocation);
        int accountNumber = AccountUtilises.numberOfAccounts(accounts);
        return accountNumber + 1;
    }
}
