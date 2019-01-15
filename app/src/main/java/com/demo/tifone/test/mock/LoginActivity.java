package com.demo.tifone.test.mock;

import android.app.Activity;
import android.os.Bundle;


public class LoginActivity extends Activity implements LoginContract.View{

    public LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getInputName() {
        return null;
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public String getPassword() {
        return null;
    }

}
