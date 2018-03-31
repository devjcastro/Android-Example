package com.devjcastro.unittestexample;

import com.devjcastro.unittestexample.domain.dto.UserCredential;
import com.devjcastro.unittestexample.domain.login.MockLoginDomain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by devmaster on 27/03/18.
 */
public class LoginDomainTest {

    MockLoginDomain domain;

    @Before
    public void setup() throws Exception {
        domain = new MockLoginDomain();
    }

    @Test
    public void loginSuccessful() throws Exception {

        //Given
        UserCredential userCredential = new UserCredential("jorge.castro", "123456");

        //When
        boolean status = domain.login(userCredential);

        //Then
        assertTrue(status);
    }


    @Test
    public void loginFail() throws Exception {

        //Given
        UserCredential userCredential = new UserCredential("jorge.castro", "12345");


        //When
        boolean status = domain.login(userCredential);

        //Then
        assertFalse(status);
    }


}