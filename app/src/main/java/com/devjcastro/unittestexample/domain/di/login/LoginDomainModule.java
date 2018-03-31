package com.devjcastro.unittestexample.domain.di.login;

import com.devjcastro.unittestexample.domain.login.ILoginDomain;
import com.devjcastro.unittestexample.domain.login.LoginDomain;


import dagger.Module;
import dagger.Provides;

/**
 * Created by devmaster on 26/03/18.
 */
@Module
class LoginDomainModule {

    @Provides
    ILoginDomain provideLoginDomain(){
        return new LoginDomain();
    }
}
