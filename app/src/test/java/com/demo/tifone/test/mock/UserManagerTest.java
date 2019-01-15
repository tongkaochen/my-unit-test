package com.demo.tifone.test.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserManagerTest {
    private UserManager mUserManager;
    @Before
    public void setup() {
        mUserManager = mock(UserManager.class);
    }

    @Test
    public void testPerformLogin() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] objects = invocation.getArguments();
                MyNetworkCallBack callBack = (MyNetworkCallBack) objects[2];
                callBack.onFail("Make fail");
                return 500;
            }
        }).when(mUserManager).performLogin(anyString(),
                anyString(), any(MyNetworkCallBack.class));
    }

}