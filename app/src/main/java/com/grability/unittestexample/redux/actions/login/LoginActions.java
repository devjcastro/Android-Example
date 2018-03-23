package com.grability.unittestexample.redux.actions.login;

import com.grability.unittestexample.redux.actions.Action;

/**
 * Created by devmaster on 23/03/18.
 */

public class LoginActions {

    public static final String SHOW_ERRORS = "SHOW_ERRORS";
    public static final String HIDE_ERRORS = "HIDE_ERRORS";

    public static Action showErrors(){
        return new Action(SHOW_ERRORS);
    }

    public static Action hideError(){
        return new Action(HIDE_ERRORS);
    }

}
