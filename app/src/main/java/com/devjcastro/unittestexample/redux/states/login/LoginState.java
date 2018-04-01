package com.devjcastro.unittestexample.redux.states.login;

/**
 * Created by Jorge Castrp on 1/04/2018.
 */

public class LoginState {
    public boolean showValidationMessage;
    public boolean showPadlockClosed;

    public LoginState(){
        this.showPadlockClosed = false;
        this.showValidationMessage = false;
    }

    public boolean isShowValidationMessage() {
        return showValidationMessage;
    }

    public void setShowValidationMessage(boolean showValidationMessage) {
        this.showValidationMessage = showValidationMessage;
    }

    public boolean isShowPadlockClosed() {
        return showPadlockClosed;
    }

    public void setShowPadlockClosed(boolean showPadlockClosed) {
        this.showPadlockClosed = showPadlockClosed;
    }
}
