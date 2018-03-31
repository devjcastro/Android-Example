package com.devjcastro.unittestexample.redux.reducers.login;

import com.devjcastro.unittestexample.redux.actions.login.LoginActions;
import com.yheriatovych.reductor.Reducer;
import com.yheriatovych.reductor.annotations.AutoReducer;

/**
 * Created by devmaster on 23/03/18.
 */
@AutoReducer
public abstract class LoginReducer implements Reducer<Boolean> {

    @AutoReducer.InitialState
    boolean initialState() {
        return false;
    }

    @AutoReducer.Action(
            value = LoginActions.SHOW_VALIDATION_MESSAGES,
            from = LoginActions.class)
    boolean showValidationMessages(boolean state) {
        return !state;
    }

    public static LoginReducer create() {
        return new LoginReducerImpl(); //Note: usage of generated class
    }
}
