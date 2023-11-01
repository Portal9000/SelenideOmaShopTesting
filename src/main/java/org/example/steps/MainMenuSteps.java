package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.example.models.ProductData;
import org.example.pages.CartPage;
import org.example.pages.DirectCategoryPage;
import org.example.pages.MainPage;
import org.example.pages.PopUpPages;
import org.example.utils.ClosePopUp;
import org.example.utils.Waiters;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;

public class MainMenuSteps {

    MainPage mainPage = new MainPage();

    public void clickMainMenu(String headerMenu) {
        mainPage.headerMenuButtons(headerMenu).click();
    }
}
