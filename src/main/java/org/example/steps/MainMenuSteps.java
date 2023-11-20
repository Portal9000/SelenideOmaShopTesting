package org.example.steps;

import org.example.pages.DirectCategoryPage;
import org.example.pages.MainPage;
import org.example.utils.ClosePopUp;

public class MainMenuSteps {

    MainPage mainPage = new MainPage();
    ClosePopUp closePopUp = new ClosePopUp();
    DirectCategoryPage directCategoryPage = new DirectCategoryPage();

    public void clickMainMenu(String headerMenu) {
        closePopUp.closePopUps();
        mainPage.headerMenuButtons(headerMenu).hover().click();
    }

    public String getBreadCrumb(String breadCrumb) {
        mainPage.breadCrumbName(breadCrumb).getText();
        return breadCrumb;
    }

    public void goToLaminatCategory() {
        mainPage.chooseCommonCategoryOtdelka.click();
        directCategoryPage.laminatCategoryPage.click();
    }
}
