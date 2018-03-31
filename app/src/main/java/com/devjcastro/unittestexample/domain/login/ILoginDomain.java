package com.devjcastro.unittestexample.domain.login;

import com.devjcastro.unittestexample.domain.dto.UserCredential;

/**
 * Created by Jorge Castrp on 26/03/2018.
 */

public interface ILoginDomain {
    boolean login(UserCredential credentials);
}
