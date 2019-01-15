package com.demo.tifone.test.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class LoginPresenterTest {
    private LoginContract.View mView;
    private LoginPresenter mPresenter;
    private UserManager mUserManager;
    private MyNetworkCallBack networkCallback;

    @Before
    public void setup() {
        mView = mock(LoginContract.View.class);
        mUserManager = mock(UserManager.class);
        networkCallback = mock(MyNetworkCallBack.class);
        mPresenter = new LoginPresenter(mView, mUserManager);
    }

    @Test
    public void testUseName() {
        emptyUserName();
        mPresenter.onLoginClicked();
        verify(mView).showErrorMessage("User name is empty");
    }
    @Test
    public void testPassword() {
        validUserName();
        emptyPassword();
        mPresenter.onLoginClicked();
        verify(mView).showErrorMessage("Password is empty");
    }
    private void validUserName() {
        when(mView.getInputName()).thenReturn("Mack");
    }
    private void emptyUserName() {
        when(mView.getInputName()).thenReturn("");
    }
    private void validPassword() {
        when(mView.getPassword()).thenReturn("123456");
    }
    private void emptyPassword() {
        when(mView.getPassword()).thenReturn("");
    }
    private void verifyPerformLoginNotInvoke() {
        String name = mView.getInputName();
        String password = mView.getPassword();
        mPresenter.login(name, password);
        verify(mUserManager, never()).performLogin(name, password, mPresenter);
    }

    private void verifyPerformLoginInvoke() {
        String name = mView.getInputName();
        String password = mView.getPassword();
        mPresenter.login(name, password);
        verify(mUserManager).performLogin(name, password, mPresenter);
    }
    @Test
    public void testLogin() {

        // empty
        emptyUserName();
        emptyPassword();
        verifyPerformLoginNotInvoke();

        validUserName();
        emptyPassword();
        verifyPerformLoginNotInvoke();

        emptyUserName();
        validPassword();
        verifyPerformLoginNotInvoke();

        // valid
        validUserName();
        validPassword();
        verifyPerformLoginInvoke();
    }

    @Test
    public void callbackLogin() {
        validUserName();
        validPassword();
        String name = mView.getInputName();
        String password = mView.getPassword();
        ArgumentCaptor<MyNetworkCallBack> captor = ArgumentCaptor.forClass(MyNetworkCallBack.class);
        mPresenter.callbackLogin(name, password);
        verify(mUserManager).performLogin(eq(name), eq(password), captor.capture());
        captor.getValue().onFail("Make fail");
        verify(mView).showErrorMessage("Make fail");
    }
    @Test
    public void testAnswer() {
        List<MyNetworkCallBack> nameList = mock(List.class);
        when(nameList.add(any(MyNetworkCallBack.class))).thenAnswer(i -> {
            MyNetworkCallBack target = i.getArgument(0);
            target.onFail("test");
            return null;
        });
        when(nameList.get(any(Integer.class))).thenAnswer(i -> {
            int target = i.getArgument(0);
            return target * target;
        });
        System.out.println(nameList.get(100));
        nameList.add(networkCallback);
        verify(networkCallback).onFail("test");

    }

}