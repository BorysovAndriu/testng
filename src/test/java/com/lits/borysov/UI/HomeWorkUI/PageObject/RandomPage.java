package com.lits.borysov.UI.HomeWorkUI.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RandomPage {

    WebDriver driver;

    public RandomPage(WebDriver driver) {
        this.driver=driver;
    }

    //Constant
    final public static String textTrueRandomNumber = "True Random Number Service";
    final public static String textCoinFlipper = "Coin Flipper";
    final public static String textCountCoin = "You flipped 200 coins of type Maximinus - Bronze/Silver Tetradrachm - Roman Empire:";
    final public static String textCountCoin2 = "You flipped 2 coins of type Australian $1:";

    @FindBy(xpath = "//h1")
    public WebElement trueRandom;

    @FindBy(xpath = "//h2")
    public WebElement coinFlipper;

    @FindBy(name = "num")
    public WebElement selectFlip;

    @FindBy(name = "cur")
    public WebElement selectCoinType;

    @FindBy(xpath = "//input[contains(@value,'Flip Coin')]")
    public WebElement buttonFlipCoin;

    @FindBy(xpath = "//p[1]")
    public WebElement countSearchCoin;

    @FindBy(xpath = "//img[contains(@title,'obverse')]")
    public List<WebElement> obverseImgList;

    @FindBy(xpath = "//img[contains(@title,'reverse')]")
    public List<WebElement> reverseImgList;

    @FindBy(xpath = "//input[contains(@value,'Go Back')]")
    public WebElement buttonGoBack;

    @FindBy(xpath = "//input[contains(@value,'Reset Form')]")
    public WebElement buttonResetForm;
}
