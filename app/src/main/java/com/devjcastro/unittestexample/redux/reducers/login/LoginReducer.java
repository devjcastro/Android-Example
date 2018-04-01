package com.devjcastro.unittestexample.redux.reducers.login;

import com.devjcastro.unittestexample.redux.AppState;
import com.devjcastro.unittestexample.redux.actions.login.LoginActions;
import com.devjcastro.unittestexample.redux.states.login.LoginState;
import com.yheriatovych.reductor.Reducer;
import com.yheriatovych.reductor.annotations.AutoReducer;

import org.pcollections.TreePVector;

/**
 * Created by devmaster on 23/03/18.
 */
@AutoReducer
public abstract class LoginReducer implements Reducer<LoginState> {

    @AutoReducer.InitialState
    LoginState initialState() {
        LoginState loginState = new LoginState();
        loginState.setShowPadlockClosed(false);
        loginState.setShowValidationMessage(false);
        return loginState;
    }


    @AutoReducer.Action(
            value = LoginActions.SHOW_VALIDATION_MESSAGES,
            from = LoginActions.class)
    LoginState showValidationMessages(LoginState state) {
        LoginState loginState = new LoginState();
        loginState.setShowValidationMessage(!state.isShowValidationMessage());
        return loginState;
    }


    @AutoReducer.Action(value = LoginActions.SHOW_PADLOCK_CLOSED, from = LoginActions.class)
    LoginState showPadlockClosed(LoginState state) {
        LoginState loginState = new LoginState();
        loginState.setShowPadlockClosed(true);
        return loginState;
    }

    @AutoReducer.Action(value = LoginActions.HIDE_PADLOCK_CLOSED, from = LoginActions.class)
    LoginState hidePadlockClosed(LoginState state) {
        LoginState loginState = new LoginState();
        loginState.setShowPadlockClosed(false);
        return loginState;
    }

    public static LoginReducer create() {
        return new LoginReducerImpl(); //Note: usage of generated class
    }
}
