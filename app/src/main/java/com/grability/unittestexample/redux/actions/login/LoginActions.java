package com.grability.unittestexample.redux.actions.login;

import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.annotations.ActionCreator;

/**
 * Created by devmaster on 23/03/18.
 */
@ActionCreator
public interface LoginActions {

    public static final String SHOW_VALIDATION_MESSAGES = "SHOW_VALIDATION_MESSAGES";

    @ActionCreator.Action(SHOW_VALIDATION_MESSAGES)
    Action showValidationMessages();

}
