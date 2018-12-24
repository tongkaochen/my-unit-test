package com.demo.tifone.test.mock;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {
    private LoginContract.View mView;
    private LoginPresenter mPresenter;
    @Before
    public void setup() {
        mView = mock(LoginContract.View.class);
        mPresenter = new LoginPresenter(mView);
    }

    @Test
    public void testUseName() {
        when(mView.getInputName()).thenReturn("");
        mPresenter.onLoginClicked();
        verify(mView).showErrorMessage("User name is empty");
    }

}