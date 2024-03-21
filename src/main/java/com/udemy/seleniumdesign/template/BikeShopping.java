package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BikeShopping extends ShoppingTemplate{

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(css = "div.button__content-wrapper")
    private WebElement cookiesBtn;
    @FindBy(css = "input[class=SearchBar_searchInput__Ql+wC]")
    private WebElement searchBox;

    @FindBy(css = "scg.Icon_icon__w6Pjo Icon_icon--white__ti2pH")
    private WebElement searchBtn;

    @FindBy(css = "div.sc-jsJBEP ckpEFm")
    private WebElement item;

    @FindBy(css = "p.price__value") //not sure why a
    private WebElement price;


    public BikeShopping(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.bike24.com/");
    }

    @Override
    public void acceptCookies() {
        this.cookiesBtn.click();
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();

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
