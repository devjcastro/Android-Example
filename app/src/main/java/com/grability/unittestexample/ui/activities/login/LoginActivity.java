package com.grability.unittestexample.ui.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grability.unittestexample.R;
import com.grability.unittestexample.domain.di.login.DaggerLoginDomainComponent;
import com.grability.unittestexample.domain.dto.UserCredential;
import com.grability.unittestexample.domain.login.ILoginDomain;
import com.grability.unittestexample.redux.actions.login.LoginActions;
import com.grability.unittestexample.redux.reducers.login.LoginReducer;
import com.yheriatovych.reductor.Actions;
import com.yheriatovych.reductor.Store;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;


    @Inject
    ILoginDomain loginDomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        configDagger();
        configReductor();
    }

    private void configDagger(){
        DaggerLoginDomainComponent.create().inject(this);
    }

    private void configReductor(){
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

    @OnClick(R.id.btnLogin)
    public void Onclick_login(){


        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        UserCredential credencials = new UserCredential(username, password);
        boolean status = loginDomain.login(credencials);

        if(status){
            Toast.makeText(this, "Usted está autenticado!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
