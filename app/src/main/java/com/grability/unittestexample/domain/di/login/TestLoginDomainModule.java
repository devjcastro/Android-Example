package com.grability.unittestexample.domain.di.login;

import com.grability.unittestexample.domain.login.ILoginDomain;
import com.grability.unittestexample.domain.login.MockLoginDomain;

/**
 * Created by Jorge Castrp on 30/03/2018.
 */

public class TestLoginDomainModule extends LoginDomainModule {
    @Override
    ILoginDomain provideLoginDomain() {
        return new MockLoginDomain();
    }
}
