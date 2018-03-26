package com.grability.unittestexample.redux.reducers.login;

import android.net.wifi.hotspot2.pps.Credential;

import com.grability.unittestexample.domain.dto.UserCredential;
import com.grability.unittestexample.redux.actions.login.LoginActions;
import com.yheriatovych.reductor.Action;
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
