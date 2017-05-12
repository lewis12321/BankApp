package com.github.lewis;

import com.opencsv.CSVReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    private File tempFile;

    @Before public void createFile() throws IOException {
        tempFile = File.createTempFile("temp", ".cvs");
    }

    @Test
    public void testSaveAccount() throws IOException {
        Input input = new Input();
        AccountCreator accountCreatorClass = new AccountCreator(input, tempFile.getPath());

        String[] accountCreator = new String[] {"40000000", "password", "0"};
        accountCreatorClass.saveAccount(accountCreator);

        CSVReader reader = new CSVReader(new FileReader(tempFile.getPath()));
        String[] account = reader.readNext();
        assertEquals("40000000", account[0]);
        assertEquals("password", account[1]);
        assertEquals("0",account[2]);
    }

    @Test
    public void testCreateAccount() throws IOException {
        Input input = new Input() {
            @Override
            public String createPassword() {
                return "password";
            }
        };
        AccountCreator accountCreator = new AccountCreator(input, tempFile.getPath());

        String[] account = accountCreator.createAccount();

        assertEquals("1", account[0]);
        assertEquals("password", account[1]);
        assertEquals("0", account[2]);
    }

    @After public void deleteFile(){
        tempFile.delete();
    }

}
