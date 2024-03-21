package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class GoogleArabic extends GoogleEnglish{

    @FindBy(css = "gws-output-pages-elements-homepage_additional_languages__als")
    private WebElement language;

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    @FindBy(id = "L2AGLb")
    private WebElement cookieBtn;


    public GoogleArabic(WebDriver driver) {
        super(driver);
    }
    @Override
    public  void launchSite(){
        this.driver.get("https://www.google.com.sa");
    }
    @Override
    public void acceptCookies(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.wait.until((d) -> this.cookieBtn.isDisplayed());
        this.cookieBtn.click();
    }

    @Override
    public void search(String keyword){
        this.wait.until((d) -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
        super.search(keyword);
    }


}
