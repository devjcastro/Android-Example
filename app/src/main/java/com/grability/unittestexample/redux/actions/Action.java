package com.grability.unittestexample.redux.actions;

/**
 * Created by devmaster on 23/03/18.
 */

public class Action {
    public final String type;
    public final Object value;

    public Action(String type) {
        this.type = type;
        this.value = null;
    }

    public Action(String type, Object value) {
        this.type = type;
        this.value = value;
    }
}
