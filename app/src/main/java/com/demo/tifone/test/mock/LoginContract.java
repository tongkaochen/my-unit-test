package com.demo.tifone.test.mock;

public interface LoginContract {
    interface View {
        String getInputName();
        void showErrorMessage(String msg);
    }
    interface Presenter {
        void onLoginClicked();
    }
}
