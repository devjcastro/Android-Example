package com.devjcastro.unittestexample.redux.actions.login;

import com.devjcastro.unittestexample.redux.states.login.LoginState;
import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.annotations.ActionCreator;

/**
 * Created by devmaster on 23/03/18.
 */
@ActionCreator
public interface LoginActions {

    public static final String SHOW_VALIDATION_MESSAGES = "SHOW_VALIDATION_MESSAGES";
    public static final String SHOW_PADLOCK_CLOSED = "SHOW_PADLOCK_CLOSED";
    public static final String HIDE_PADLOCK_CLOSED = "HIDE_PADLOCK_CLOSED";

    @ActionCreator.Action(SHOW_VALIDATION_MESSAGES)
    Action showValidationMessages();

    @ActionCreator.Action(SHOW_PADLOCK_CLOSED)
    Action showPadlockClosed();

    @ActionCreator.Action(HIDE_PADLOCK_CLOSED)
    Action hidePAdlockClosed();
}
