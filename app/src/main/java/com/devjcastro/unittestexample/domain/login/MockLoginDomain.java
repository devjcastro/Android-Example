package com.devjcastro.unittestexample.domain.login;

import com.devjcastro.unittestexample.domain.dto.UserCredential;

/**
 * Created by Jorge Castrp on 30/03/2018.
 */

public class MockLoginDomain implements ILoginDomain {
    @Override
    public boolean login(UserCredential credentials) {
        if(credentials.getUsername().equalsIgnoreCase("jorge.castro") && credentials.getPassword().equals("123456")){
            return true;
        }
        else{
            return false;
        }
    }
}
