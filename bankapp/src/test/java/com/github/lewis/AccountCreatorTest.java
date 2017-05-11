package com.github.lewis;

import com.opencsv.CSVReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    private File tempFile;

    @Before public void createFile() throws IOException {
        tempFile = File.createTempFile("temp", ".cvs");
    }

    @Test
    public void testCreateAccount() throws IOException {
        String[] accountCreator = new String[] {"40000000", "password", "0"};
        AccountCreator.saveAccount(tempFile.getPath(), accountCreator);

        CSVReader reader = new CSVReader(new FileReader(tempFile.getPath()));
        String[] account = reader.readNext();
        assertEquals("40000000", account[0]);
        assertEquals("password", account[1]);
        assertEquals("0",account[2]);
    }

    @After public void deleteFile(){
        tempFile.delete();
    }

}
