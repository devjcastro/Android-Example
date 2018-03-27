package com.grability.unittestexample.domain.login;

import com.grability.unittestexample.domain.dto.UserCredential;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by devmaster on 26/03/18.
 */

public class LoginDomain implements ILoginDomain {


    public LoginDomain(){}

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
