package org.ait.demoqa.tests.alertWindows;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.alertWindows.iframesPage;
import org.ait.demoqa.pages.alertWindows.NestedFramesPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFramesWindows();
    }

    @Test
    public void iframesTest(){
        new SidePanel(driver).selectFrames();
        new iframesPage(driver).returnListOfFrames().switchToIframeByIndex(1);
    }

    @Test
    public void switchToIframeByIDTest(){
        new SidePanel(driver).selectFrames();
        new iframesPage(driver).switchToIframeByID();
    }

    @Test
    public void handleNestedIframeTest(){
        new SidePanel(driver).selectNestedFrames();
        new NestedFramesPage(driver).handleNestedIframes();

    }
}
