package com.devjcastro.unittestexample.redux;

import com.devjcastro.unittestexample.redux.states.login.LoginState;

/**
 * Created by Jorge Castrp on 31/03/2018.
 */

public class AppState {
    public final LoginState loginState;
    public AppState(LoginState loginState){
        this.loginState = loginState;
    }
}
