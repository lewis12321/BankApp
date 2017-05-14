package com.github.lewis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountManagerTest {

    private File tempFile;

    @Before
    public void createFile() throws IOException {
        tempFile = File.createTempFile("temp", ".cvs");
    }

    @Test
    public void testDepositFunds() throws Exception {
        Input input = new Input();
        AccountManager accountManager = new AccountManager(tempFile.getPath());
        AccountCreator accountCreatorClass = new AccountCreator(input, tempFile.getPath());

        String[] accountCreator = new String[]{"40000000", "password", "0"};
        accountCreatorClass.saveAccount(accountCreator);

        accountManager.depositFunds("40000000", 100);
        List<String[]> accounts = AccountUtilises.readFromCSV(tempFile.getPath());
        String balance = accounts.get(0)[2];

        assertEquals("100", balance);

    }

    @Test
    public void testWithdrawalFunds() throws Exception {
        Input input = new Input();
        AccountManager accountManager = new AccountManager(tempFile.getPath());
        AccountCreator accountCreatorClass = new AccountCreator(input, tempFile.getPath());

        String[] accountCreator = new String[]{"40000000", "password", "100"};
        accountCreatorClass.saveAccount(accountCreator);

        accountManager.withdrawalFunds("40000000", 50);
        List<String[]> accounts = AccountUtilises.readFromCSV(tempFile.getPath());
        String balance = accounts.get(0)[2];

        assertEquals("50", balance);

    }

    @After public void deleteFile(){
        tempFile.delete();
    }

}

//Given I have an account, when i deposit funds, then my credit increases.#
