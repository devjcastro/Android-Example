package com.devjcastro.unittestexample.domain.dto;

/**
 * Created by devmaster on 23/03/18.
 */

public class UserCredential {

    private String username;
    private String password;

    public UserCredential(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
