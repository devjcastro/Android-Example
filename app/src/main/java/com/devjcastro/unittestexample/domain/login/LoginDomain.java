package com.devjcastro.unittestexample.domain.login;

import com.devjcastro.unittestexample.domain.dto.UserCredential;

/**
 * Created by devmaster on 26/03/18.
 */

public class LoginDomain implements ILoginDomain {

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
