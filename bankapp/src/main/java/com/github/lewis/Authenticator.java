package com.github.lewis;

import java.io.IOException;
import java.util.List;

class Authenticator {

    private Input input;

    Authenticator(Input input){
        this.input = input;
    }

    boolean loginAuthorised(String fileLocation, String accountNumber) throws IOException {
        List<String[]> accounts = AccountUtilises.readFromCSV(fileLocation);
        String password = input.getPassword();

        for (String[] individualAccountNum : accounts) {
            String compareAccountNum = individualAccountNum[0];
            String comparePassword = individualAccountNum[1];

            if (compareAccountNum.equals(accountNumber) && comparePassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

}
