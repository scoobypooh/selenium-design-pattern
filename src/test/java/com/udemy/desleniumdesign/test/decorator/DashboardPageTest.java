package com.udemy.desleniumdesign.test.decorator;

import com.udemy.desleniumdesign.test.BaseTest;
import com.udemy.seleniumdesign.decorator.DashBoardPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashBoardPage dashBoardPage;

    @BeforeTest
    public void setDashboarPage(){
        this.dashBoardPage = new DashBoardPage(driver);
    }

    @Test (dataProvider = "getData")
    public void roleTest(Consumer<DashBoardPage> role){
        this.dashBoardPage.goTo();
        role.accept(this.dashBoardPage);
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                Decoratos.guestPage,
                Decoratos.adminPage,
                Decoratos.suPage
        };
    }
}
