package com.lits.borysov.UI.HomeWorkUI;

import com.lits.borysov.UI.HomeWorkUI.PageObject.GmailPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestLoginEmail extends TestBase {

    @Test
    public void loginEmail() throws InterruptedException {

        //Go to Gamil
        driver.get("https://mail.google.com/");

        //Login
        GmailPage email = PageFactory.initElements(driver,GmailPage.class);

        //Fill email
        email.fieldEmail.sendKeys("tester.andrew.1234@gmail.com", Keys.ENTER);

        //Fill password
        email.fieldPassword.sendKeys("192837465tester", Keys.ENTER);



    }
}
