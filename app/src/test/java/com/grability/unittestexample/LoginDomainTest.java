package com.grability.unittestexample;

import com.grability.unittestexample.domain.dto.UserCredential;
import com.grability.unittestexample.domain.login.LoginDomain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by devmaster on 27/03/18.
 */
public class LoginDomainTest {

    @Test
    public void loginSuccessful() throws Exception {

        //Given
        LoginDomain domain = new LoginDomain();


        //When
        UserCredential userCredential = new UserCredential("jorge.castro", "123456");
        boolean status = domain.login(userCredential);

        //Then
        assertTrue(status);
    }


    @Test
    public void loginFail() throws Exception {

        //Given
        LoginDomain domain = new LoginDomain();


        //When
        UserCredential userCredential = new UserCredential("jorge.castro", "12345");
        boolean status = domain.login(userCredential);

        //Then
        assertFalse(status);
    }


}