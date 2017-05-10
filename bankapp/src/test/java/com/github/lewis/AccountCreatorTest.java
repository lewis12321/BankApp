package com.github.lewis;

import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    @Test
    public void testCreateAccount() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Fraser\\IdeaProjects\\BankApp\\Accounts\\accounts.csv"));
        String[] account = reader.readNext();
        assertEquals(account[0], "40000000");
        assertEquals(account[1], "password");
        assertEquals(account[2], "0");
    }



}
