package com.devjcastro.unittestexample.ui.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.devjcastro.unittestexample.R;
import com.devjcastro.unittestexample.domain.di.login.DaggerLoginDomainComponent;
import com.devjcastro.unittestexample.domain.dto.UserCredential;
import com.devjcastro.unittestexample.domain.login.ILoginDomain;
import com.devjcastro.unittestexample.redux.actions.login.LoginActions;
import com.devjcastro.unittestexample.redux.reducers.login.LoginReducer;
import com.devjcastro.unittestexample.redux.states.login.LoginState;
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

    @BindView(R.id.imgPadlock)
    ImageView imgPadlock;


    @Inject
    ILoginDomain loginDomain;


    Store<LoginState> loginStorage;
    LoginActions actions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        configDagger();
        configReductor();
        setupEventImagePadlock();


        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(TextUtils.isEmpty(charSequence)){
                    loginStorage.dispatch(actions.hidePAdlockClosed());
                }
                else{
                    loginStorage.dispatch(actions.showPadlockClosed());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void configDagger(){
        DaggerLoginDomainComponent.create().inject(this);
    }

    private void configReductor(){
        loginStorage = Store.create(LoginReducer.create());

        LoginState initialState = loginStorage.getState();
        Log.d("AppState 1", initialState.isShowValidationMessage() + "");
        actions = Actions.from(LoginActions.class);

        //you can subscribe to state changes
        loginStorage.subscribe(state ->
                Log.d("AppState 2", state.isShowValidationMessage()+"")
        );

        loginStorage.dispatch(actions.showValidationMessages());
        Log.d("AppState 3", loginStorage.getState().isShowValidationMessage()+"");


        setupEventImagePadlock();

    }


    private void setupEventImagePadlock(){
        imgPadlock.setBackgroundResource(R.drawable.if_padlock_open);
        loginStorage.subscribe(loginState -> {
            if(loginState.isShowPadlockClosed()){
                imgPadlock.setBackgroundResource(R.drawable.if_padlock_closed);
            }
            else{
                imgPadlock.setBackgroundResource(R.drawable.if_padlock_open);
            }
        });
    }

    @OnClick(R.id.btnLogin)
    public void Onclick_login(){


        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        UserCredential credencials = new UserCredential(username, password);
        boolean status = loginDomain.login(credencials);

        if(status){
            Toast.makeText(this, "Usted está autenticado!", Toast.LENGTH_SHORT).show();
            etPassword.setText("");
        }
        else{
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
