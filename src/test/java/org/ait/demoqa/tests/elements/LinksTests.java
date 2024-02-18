package org.ait.demoqa.tests.elements;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.alertWindows.AlertsPage;
import org.ait.demoqa.pages.elements.BrokenLinksImagesPage;
import org.ait.demoqa.pages.elements.LinksPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAFW();
        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptAlertTest() {
        new AlertsPage(driver).acceptAlert();
    }

    @Test
    public void timerAlertButtonTest() {
        new AlertsPage(driver).acceptAlertInFiveSecond();
    }

    @Test
    public void confirmAlertTest() {
        new AlertsPage(driver).confirmAlert("cancel");
    }

    @Test
    public void sendTextToAlertTest() {
        new AlertsPage(driver).sendTextToAlert("Guten Tag!")
                .assertAcceptAlert("Guten Tag!");
    }
}