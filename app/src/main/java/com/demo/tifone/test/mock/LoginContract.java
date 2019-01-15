package com.demo.tifone.test.mock;

public interface LoginContract {
    interface View {
        String getInputName();
        void showErrorMessage(String msg);
        String getPassword();
    }
    interface Presenter {
        void onLoginClicked();
        void login(String name, String password);
    }
}
