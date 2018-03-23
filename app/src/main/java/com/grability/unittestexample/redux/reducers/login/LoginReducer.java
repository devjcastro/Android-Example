package com.grability.unittestexample.redux.reducers.login;

import android.net.wifi.hotspot2.pps.Credential;

import com.grability.unittestexample.domain.dto.UserCredential;
import com.grability.unittestexample.redux.actions.login.LoginActions;
import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Reducer;

/**
 * Created by devmaster on 23/03/18.
 */

public class LoginReducer implements Reducer<UserCredential> {

    @Override
    public UserCredential reduce(UserCredential userCredential, Action action) {
        switch (action.type){
            case LoginActions.SHOW_ERRORS:
                return null;
        }
        return null;
    }
}
