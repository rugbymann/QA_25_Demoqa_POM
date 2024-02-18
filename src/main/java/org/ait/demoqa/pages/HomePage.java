package org.ait.demoqa.pages;

import org.ait.demoqa.pages.alertWindows.AlertsPage;
import org.ait.demoqa.pages.alertWindows.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card.mt-4.top-card:nth-child(6)")
    WebElement bookStore;


    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card.mt-4.top-card:nth-child(3)")
    WebElement alertsFramesWindows;
    public SidePanel getAlertsFramesWindows() {
        clickWithJSExecutor(alertsFramesWindows,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Forms']")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJSExecutor(forms, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card.mt-4.top-card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,200);
        return new SidePanel(driver);
    }

    @FindBy(id = "app")
    WebElement alertsFrameWindowsApp;

    public AlertsPage getAFW() {
        click(alertsFrameWindowsApp);
        return new AlertsPage(driver);
    }
    @FindBy(xpath = " //span[contains(text(),'Alerts')]")
    WebElement alerts;

    public AlertsPage getAlerts(){
        click((alerts));
        return new AlertsPage(driver);
    }

    @FindBy(xpath = " //span[contains(text(),'Browser Windows')]")
    WebElement windows;
    public WindowsPage getBrowserWindows() {
        click(windows);
        return new WindowsPage(driver);
    }
}