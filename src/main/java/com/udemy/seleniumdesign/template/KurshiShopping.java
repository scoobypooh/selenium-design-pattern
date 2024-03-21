package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KurshiShopping extends ShoppingTemplate{

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement cookiesBtn;

    @FindBy(id = "action-search")   //dunno
    private WebElement searchBtn;

    @FindBy(css = "span.product-image-wrapper")   //dunno
    private WebElement item;

    @FindBy(id = "product-price-294130")    //dunno
    private WebElement price;

    public KurshiShopping(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.kursi.lv/lv/");

    }
    @Override
    public void acceptCookies() {
        this.wait.until((d) -> this.cookiesBtn.isDisplayed());
        this.cookiesBtn.click();
    }

    @Override
    public void searchForProduct() {
        this.searchBox.click();
        this.searchBox.sendKeys(this.product);

    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );
    }
}
