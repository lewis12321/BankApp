package com.github.lewis;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        String fileLocation = args[0];
        AccountCreator accountCreator = new AccountCreator(input, fileLocation);
        Authenticator authenticator = new Authenticator(input);

        String response = input.getOption();



        if (response.equals("1")){
            String[] account = accountCreator.createAccount();
            accountCreator.saveAccount(account);
        }else if (response.equals("2")){
            String accountNumber = input.getAccountNumber();
            System.out.println(authenticator.loginAuthorised(fileLocation, accountNumber));
        }

    }

}
