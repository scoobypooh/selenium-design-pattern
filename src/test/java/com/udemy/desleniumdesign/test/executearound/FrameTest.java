package com.udemy.desleniumdesign.test.executearound;

import com.udemy.desleniumdesign.test.BaseTest;
import com.udemy.seleniumdesign.executearound.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();

        this.mainPage.onFrameA(a -> {a.setFirstName("fn1"); a.setLastName("ln1");});
        this.mainPage.onFrameB(b -> b.setFirstName("fn2"));
        this.mainPage.onFrameC(c -> c.setLastName("ln3"));
    }
}
