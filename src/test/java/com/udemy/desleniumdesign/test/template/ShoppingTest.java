package com.udemy.desleniumdesign.test.template;

import com.udemy.desleniumdesign.test.BaseTest;
import com.udemy.seleniumdesign.template.KurshiShopping;
import com.udemy.seleniumdesign.template.BikeShopping;
import com.udemy.seleniumdesign.template.ShoppingTemplate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test (dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new KurshiShopping(driver, "sony"),
                new BikeShopping(driver,"cube")
        };
    }
}
