package org.example.utils;

import org.example.pages.PopUpPages;

public class ClosePopUp {

    PopUpPages popUpPages = new PopUpPages();
    public void closePopUps() {
//        if (popUpPages.popUp1bgr.isDisplayed()) {
//            System.out.println("PopUp1 is displayed");
//            popUpPages.popUp1btn.hover().click();
//        }
        if (popUpPages.popUp2.isDisplayed()) {
            System.out.println("PopUp2 is displayed");
            popUpPages.popUp2.scrollIntoView("{block: \"center\"}").hover().click();
        }
        if (popUpPages.popUp3.isDisplayed()) {
            System.out.println("PopUp3 is displayed");
            popUpPages.popUp3.hover().click();
        }
        if (popUpPages.popUp4.isDisplayed()) {
            System.out.println("PopUp4 is displayed");
            popUpPages.popUp4.scrollIntoView("{block: \"center\"}").hover().click();
        }
        if (popUpPages.popUp5.isDisplayed()) {
            System.out.println("PopUp5 is displayed");
            popUpPages.popUp5.hover().click();
        }
    }
}
