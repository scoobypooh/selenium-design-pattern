package com.udemy.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage{

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "div.yuRUbf")
    private List<WebElement> results;

    @FindBy(id = "L2AGLb")
    private WebElement cookieBtn;

    public GoogleEnglish(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement cookieBtn = driver.findElement(By.id(("L2AGLb")));
        //cookieBtn.click();
    }
    @Override
    public void acceptCookies(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.wait.until((d) -> this.cookieBtn.isDisplayed());
        this.cookieBtn.click();
    }

    @Override
    public void search(String keyword) {
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }

}
