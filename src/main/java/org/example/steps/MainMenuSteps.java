package org.example.steps;

import org.example.pages.MainPage;
import org.example.utils.Waiters;

public class MainMenuSteps {

    MainPage mainPage = new MainPage();

    public void clickMainMenu(String headerMenu) {
//        Waiters.sleep();
        System.out.println(mainPage.headerMenuButtons(headerMenu) + " --- clickMainMenu");
        mainPage.headerMenuButtons(headerMenu).hover().click();
    }

    public String getBreadCrumb(String breadCrumb) {
        System.out.println(mainPage.breadCrumbName(breadCrumb).getText() + " --- SeeBreadCrumb");
        mainPage.breadCrumbName(breadCrumb).getText();
        return breadCrumb;
    }
}
