package com.demo.tifone.test.dagger;

import com.demo.tifone.test.mock.UserManager;


public class MyModule {

    UserManager sGenerateUserManager() {
        return new UserManager();
    }
}
