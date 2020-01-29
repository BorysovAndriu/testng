package com.lits.borysov.UI.HomeWorkUI.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage {

    WebDriver driver;

    public GmailPage(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(id = "identifierId")
    public WebElement fieldEmail;

    @FindBy(name = "password")
    public WebElement fieldPassword;

}
