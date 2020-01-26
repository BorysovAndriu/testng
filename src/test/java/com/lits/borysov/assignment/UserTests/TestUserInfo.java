package com.lits.borysov.assignment.UserTests;

import com.lits.borysov.assignment.Models.UserModel;
import com.lits.borysov.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserInfo extends UserService {

    @Test()
    public void getUserInfo(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_1, email_1)
                .getR().getAccess_token();

        //Get User Info
        UserModel.UserInfoModel userInfo = getUserInfo(userToken);

        //Verify user info
        Assert.assertEquals(userInfo.getEmail(), email_1);
        Assert.assertEquals(userInfo.getId(), idUser_1);
        Assert.assertEquals(userInfo.getFirstName(), "andriu");
        Assert.assertEquals(userInfo.getLastName(), "boris");
    }
}
