package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class GoogleFrench extends GoogleEnglish{

    @FindBy(css = "gws-output-pages-elements-homepage_additional_languages__als")
    private WebElement language;

    @FindBy(id = "L2AGLb")
    private WebElement cookieBtn;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");

    }
    @Override
    public void acceptCookies(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.wait.until((d) -> this.cookieBtn.isDisplayed());
        this.cookieBtn.click();
    }
}
