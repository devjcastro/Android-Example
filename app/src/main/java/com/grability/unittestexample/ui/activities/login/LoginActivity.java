package com.grability.unittestexample.ui.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.grability.unittestexample.R;
import com.grability.unittestexample.redux.actions.login.LoginActions;
import com.grability.unittestexample.redux.reducers.login.LoginReducer;
import com.yheriatovych.reductor.Actions;
import com.yheriatovych.reductor.Store;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initStorage();
    }

    private void initStorage(){
        Store<Boolean> loginStorage = Store.create(LoginReducer.create());

        Boolean initialState = loginStorage.getState();
        Log.d("Initial State", initialState.toString());
        LoginActions actions = Actions.from(LoginActions.class);

        //you can subscribe to state changes
        loginStorage.subscribe(state ->
                Log.d("Show State Change", state.toString())
        );

        loginStorage.dispatch(actions.showValidationMessages());
        initialState = loginStorage.getState();
        Log.d("Initial State", initialState.toString());
    }
}
