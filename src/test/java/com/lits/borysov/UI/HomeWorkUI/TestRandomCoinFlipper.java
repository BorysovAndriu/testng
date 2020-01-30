package com.lits.borysov.UI.HomeWorkUI;

import com.lits.borysov.UI.HomeWorkUI.PageObject.RandomPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.lits.borysov.UI.HomeWorkUI.PageObject.RandomPage.*;

public class TestRandomCoinFlipper extends TestBase{

    @Test
    public void chooseRandomCoin(){

        //Go to Web site https://www.random.org/coins/
        driver.get("https://www.random.org/coins/");

        //Verify text True Random Number Service
        RandomPage randomPage = PageFactory.initElements(driver,RandomPage.class);
        Assert.assertTrue(randomPage.trueRandom.isDisplayed());
        Assert.assertEquals(randomPage.trueRandom.getText(),textTrueRandomNumber);

        //Verify text Coin Flipper
        Assert.assertTrue(randomPage.coinFlipper.isDisplayed());
        Assert.assertEquals(randomPage.coinFlipper.getText(),textCoinFlipper);

        //Select flit = 200
        Select flit = new Select(randomPage.selectFlip);
        flit.selectByValue("200");

        //Select coin type = Maximinus - Bronze/Silver Tetradrachm - Roman Empire
        Select coinType = new Select(randomPage.selectCoinType);
        coinType.selectByVisibleText("Maximinus - Bronze/Silver Tetradrachm - Roman Empire");

        //Click by Flip Coin
        randomPage.buttonFlipCoin.click();

        //Verify count coins
        Assert.assertEquals(randomPage.countSearchCoin.getText(),textCountCoin);
        Assert.assertEquals(randomPage.obverseImgList.size() + randomPage.reverseImgList.size(),200);
        System.out.println("Count obverse: " + randomPage.obverseImgList.size());
        System.out.println("Count reverse: " + randomPage.reverseImgList.size());

        //Go Back and reset form
        randomPage.buttonGoBack.click();
        randomPage.buttonResetForm.click();

        //Select flit = 2
        flit = new Select(randomPage.selectFlip);
        flit.selectByValue("2");

        //Select coin type = 2
        coinType = new Select(randomPage.selectCoinType);
        coinType.selectByVisibleText("Australian $1");

        //Click by Flip Coin
        randomPage.buttonFlipCoin.click();

        //Verify count coins
        Assert.assertEquals(randomPage.countSearchCoin.getText(),textCountCoin2);
        Assert.assertEquals(randomPage.obverseImgList.size() + randomPage.reverseImgList.size(),2);
    }
}
