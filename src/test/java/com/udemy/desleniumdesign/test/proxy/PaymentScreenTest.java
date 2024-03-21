package com.udemy.desleniumdesign.test.proxy;


import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.desleniumdesign.test.BaseTest;
import com.udemy.seleniumdesign.Proxy.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        System.setProperty("env","PROD");
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Otto", "Schmtz", "apustulis@fake.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = paymentScreen.getOrder().placeOrder();

        System.out.println(
                "Order Number: " + orderNumber
        );

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }
    @DataProvider
    public Object[][] getData(){

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "789654123");
        cc.put("year", "2024");
        cc.put("cvv", "741");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "BOFA");
        nb.put("account", "myAcc1");
        nb.put("pin", "741");

        Map<String, String> paypal = Maps.newHashMap();
        paypal.put("paypal_username", "keksis");
        paypal.put("paypal_password", "myAcc1");


        return new Object[][]{
                {new CreditCard(), cc},
                {new NetBanking(), nb},
                {new Paypal(), paypal}

        };
    }
}
