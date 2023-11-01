package org.example.utils;

import org.example.pages.PopUpPages;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClosePopUp {

    PopUpPages popUpPages = new PopUpPages();
    public void closePopUps() {
        if (popUpPages.popUp1bgr.isDisplayed()) {
            log.info("popUp1bgr is closed");
            popUpPages.popUp1btn.hover().click();
        }
    }
}
