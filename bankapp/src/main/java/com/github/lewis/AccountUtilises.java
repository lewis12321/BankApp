package com.github.lewis;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class AccountUtilises {

    static List<String[]> readFromCSV(String fileLocation) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(fileLocation));

        return csvReader.readAll();
    }

    static int numberOfAccounts(List<String[]> accounts){
        return accounts.size();
    }
}
