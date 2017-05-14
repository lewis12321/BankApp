package com.github.lewis;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class AccountManager {

    private String fileLocation;

    AccountManager(String fileLocation){
        this.fileLocation = fileLocation;
    }

    void viewFunds(String accountNum) throws IOException {
        List<String[]> accounts = AccountUtilises.readFromCSV(fileLocation);

        for (String[] accountRow : accounts) {
            String tempAccountNum = accountRow[0];
            if (tempAccountNum.equals(accountNum)){
                System.out.println("You have £" + accountRow[2]);
            }
        }
    }

    void depositFunds(String accountNum, int depositAmount) throws IOException {
        List<String[]> accounts = AccountUtilises.readFromCSV(fileLocation);
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation));

        for (String[] accountRow : accounts) {
            String tempAccountNum = accountRow[0];
            if (tempAccountNum.equals(accountNum)){
                 int total = Integer.parseInt(accountRow[2]) + depositAmount;
                 accountRow[2] = Integer.toString(total);
                 System.out.println("You have deposited £" + depositAmount);
                 System.out.println("You now have £" + total + " in total.");
            }
        }

        writer.writeAll(accounts);
        writer.flush();
        writer.close();

    }

    void withdrawalFunds(String accountNum, int withdrawalAmount) throws IOException {
        List<String[]> accounts = AccountUtilises.readFromCSV(fileLocation);
        CSVWriter writer = new CSVWriter(new FileWriter(fileLocation));

        for (String[] accountRow : accounts) {
            String tempAccountNum = accountRow[0];
            if (tempAccountNum.equals(accountNum)){
                int total = Integer.parseInt(accountRow[2]) - withdrawalAmount;
                accountRow[2] = Integer.toString(total);
                System.out.println("You have withdrawn £" + withdrawalAmount);
                System.out.println("You now have £" + total + " in total.");
            }
        }

        writer.writeAll(accounts);
        writer.flush();
        writer.close();

    }



}
