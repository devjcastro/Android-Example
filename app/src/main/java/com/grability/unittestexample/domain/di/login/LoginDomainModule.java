package com.grability.unittestexample.domain.di.login;

import com.grability.unittestexample.domain.login.ILoginDomain;
import com.grability.unittestexample.domain.login.LoginDomain;


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
