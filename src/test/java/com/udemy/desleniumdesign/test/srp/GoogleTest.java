package com.udemy.desleniumdesign.test.srp;

import com.udemy.desleniumdesign.test.BaseTest;
import com.udemy.seleniumdesign.srp.main.GoogleMainPage;
import com.udemy.seleniumdesign.srp.result.GoogleResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest extends BaseTest {

    public GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index){

        //String keyword = "selenium webdriver";
        //int index = 3;

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieBtn = driver.findElement(By.id("L2AGLb"));
        cookieBtn.click();

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();
        System.out.println(googleResultPage.getResultStat().getStat());


    }

    @DataProvider
    public Object[][] getData(){
            return new Object[][]{
                    {"selenium", 3},
                    {"docker", 2}
            };
    }


}
