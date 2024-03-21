package com.udemy.desleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashBoardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decoratos {

    private static void shouldDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //ingridients..
    private static final Consumer<DashBoardPage>adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponenets());
    private static final Consumer<DashBoardPage>adminComponentNotPresent = (dp) -> shouldNotDisplay((dp.getAdminComponenets()));

    private static final Consumer<DashBoardPage>suComponentPresent = (dp) -> shouldDisplay(dp.getSuperuserComponenets());
    private static final Consumer<DashBoardPage>suComponentNotPresent = (dp) -> shouldNotDisplay((dp.getSuperuserComponenets()));

    private static final Consumer<DashBoardPage>guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponenets());
    private static final Consumer<DashBoardPage>guestComponentNotPresent = (dp) -> shouldNotDisplay((dp.getGuestComponenets()));

    //role selection
    private static final Consumer<DashBoardPage>adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashBoardPage>suSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashBoardPage>guestSelection = (dp) -> dp.selectRole("guest");

    //user role pages
    public static final Consumer<DashBoardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(suComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashBoardPage> suPage = suSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashBoardPage> adminPage = adminSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentPresent);

}
