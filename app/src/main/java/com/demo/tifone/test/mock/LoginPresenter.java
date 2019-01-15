package com.demo.tifone.test.mock;

import com.demo.tifone.test.StringUtil;
public class LoginPresenter implements LoginContract.Presenter, MyNetworkCallBack {
    private LoginContract.View mView;
    private UserManager mUserManager;
    public LoginPresenter(LoginContract.View view, UserManager userManager) {
        mView = view;
        mUserManager = userManager;
    }

    @Override
    public void onLoginClicked() {
        String userName = mView.getInputName();
        if (!StringUtil.isValidString(userName)) {
            mView.showErrorMessage("User name is empty");
        }
        String password = mView.getPassword();
        if (!StringUtil.isValidString(password, 6)) {
            mView.showErrorMessage("Password is empty");
        }
        login(userName, password);
    }


    @Override
    public void login(String name, String password) {
        if (!StringUtil.isValidString(name)
                || !StringUtil.isValidString(password, 6)) {
            return;
        }
        mUserManager.performLogin(name, password, this);
    }
    public void callbackLogin(String name, String password) {
        if (!StringUtil.isValidString(name)
                || !StringUtil.isValidString(password, 6)) {
            return;
        }
        mUserManager.performLogin(name, password, new MyNetworkCallBack() {
            @Override
            public void onSuccess(Object data) {
                LoginPresenter.this.onSuccess(data);
                System.out.println("onSuccess");
            }

            @Override
            public void onFail(String error) {
                mView.showErrorMessage(error);
                System.out.println("onFail = " + error);
            }
        });
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onFail(String error) {

    }
}
