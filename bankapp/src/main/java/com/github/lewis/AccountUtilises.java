package com.github.lewis;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Fraser on 11/05/2017.
 */
public class AccountUtilises {

    public static List<String[]> readFromCSV(String fileLocation) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(fileLocation));
        List<String[]> accounts = csvReader.readAll();

        return accounts;
    }

    public static int numberOfAccounts(List<String[]> accounts){
        int numberOfAccounts = accounts.size();
        return numberOfAccounts;
    }
}
