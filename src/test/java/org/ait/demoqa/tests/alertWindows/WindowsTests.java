package org.ait.demoqa.tests.alertWindows;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.alertWindows.WindowsPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAFW();
        new HomePage(driver).getBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new WindowsPage(driver)
                .switchToNewTab(1)
                .assertNewTab("This is a sample page");
    }

    @Test
    public void newWindowTest() {
        new WindowsPage(driver)
                .switchToNewWindow()
                .assertNewTab("This is a sample page");
    }



}

