package com.lits.borysov.UI.HomeWorkUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestLoginLits extends TestBase {

    @Test
    public void loginLits(){

        //Go to
        driver.get("https://sites.google.com/view/library-automation-lits/home");

        //Click to login button
        driver.findElement(By.xpath("//a[contains(@aria-label,'Login')]")).click();

        //Switch window
        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));

        //Fill fields for login
        driver.findElement(By.id("email")).sendKeys("andriu.test.post.1@gmail.com");
        driver.findElement(By.id("password")).sendKeys("192837465");

        //Login button click
        driver.findElement(By.id("btn-login")).click();

        //Verify url libery
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Library')]")));
        Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://search-app-263e2.web.app/");
    }
}
