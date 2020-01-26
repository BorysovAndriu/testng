package com.lits.borysov.assignment.UserTests;

import com.lits.borysov.assignment.Models.UserModel;
import com.lits.borysov.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserLogin extends UserService {


    @Test
    public void testUserLogin(){

        //Login
        UserModel user = userLogin(passwordFromEmail_1, email_1);

        //verify token is not empty
        Assert.assertFalse(user.getR().getAccess_token().isEmpty());
    }
}
