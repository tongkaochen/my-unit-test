package com.demo.tifone.test.mock;

import android.text.TextUtils;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    public LoginPresenter(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void onLoginClicked() {
        String userName = mView.getInputName();
        if (userName == null || "".equals(userName)) {
            mView.showErrorMessage("User name is empty");
        }
    }
}
