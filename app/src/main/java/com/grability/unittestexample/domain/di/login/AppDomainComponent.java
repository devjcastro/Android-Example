package com.grability.unittestexample.domain.di.login;

import com.grability.unittestexample.ui.activities.login.LoginActivity;

import dagger.Component;

/**
 * Created by devmaster on 26/03/18.
 */
@Component(modules = AppDomainModule.class)
public interface AppDomainComponent {
    void inject(LoginActivity activity);
}
