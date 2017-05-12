package com.github.lewis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthenticatorTest {
    private File tempFile;

    @Before public void createFile() throws IOException {
        tempFile = File.createTempFile("temp", ".cvs");
    }

    @Test
    public void testLoginSuccessful() throws IOException {
        Input input = new Input()
        {
            @Override
            public String createPassword() {
                return "password";
            }

            @Override
            public String getPassword() {
                return "password";
            }
        };

        Authenticator authenticator = new Authenticator(input);
        AccountCreator accountCreator = new AccountCreator(input, tempFile.getPath());

        String[] account = accountCreator.createAccount();
        accountCreator.saveAccount(account);
        assertTrue(authenticator.loginAuthorised(tempFile.getPath(), account[0]));
    }

    @Test
    public void testLoginFailure() throws IOException {
        Input input = new Input()
        {
            @Override
            public String createPassword() {
                return "password";
            }

            @Override
            public String getPassword() {
                return "test";
            }
        };

        Authenticator authenticator = new Authenticator(input);
        AccountCreator accountCreator = new AccountCreator(input, tempFile.getPath());

        String[] account = accountCreator.createAccount();
        accountCreator.saveAccount(account);
        assertFalse(authenticator.loginAuthorised(tempFile.getPath(), account[0]));
    }

    @After
    public void tearDown() throws Exception {

    }

    // Given a created account with account num 1 and password is password
    // When I log in with account num 1 and password is password
    // THen I log in

    // Given a created account with account num 1 and password is password
    // When I log in with account num 1 and password is test
    // THen I don't log in

}