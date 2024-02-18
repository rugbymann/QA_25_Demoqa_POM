package org.ait.demoqa.pages.alertWindows;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class iframesPage extends BasePage {
    public iframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public iframesPage returnListOfFrames() {
        System.out.println("The total numbers of iframes: " + iframes.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt((js.executeScript("return window.length").toString()));
        System.out.println("The total numbers of iframes: " +numberOfIframes );

        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public iframesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text of the iframe: " + sampleHeading.getText());

        return this;

    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "framesWrapper")
    WebElement framesWrapper;

    public iframesPage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        driver.switchTo().defaultContent();   //для возврата на главную страницу
        System.out.println("Text of the iframe: " + framesWrapper.getText());
        return this;
    }
    @FindBy(tagName = "body")
    WebElement body;

    public iframesPage switchToNestedIframe() {
        System.out.println("The total number of frames on the page " + iframes.size());
        driver.switchTo().frame(frame1);
        System.out.println("Frame 1 is " + body.getText());
        System.out.println("The total number of iframes in the parent iframe: " + iframes.size());

        driver.switchTo().frame(0);
        System.out.println("Frame 2 is " + body.getText());
        System.out.println("The total number of iframes in the child iframe: " + iframes.size());

        // что бы вернуться в родительский фрейм
        //driver.switchTo().parentFrame();
        //System.out.println("Frame 1 is " + body.getText());

        // что бы вернуться в основной контент
        driver.switchTo().defaultContent();
        System.out.println("Text on the maim page: " + framesWrapper.getText());
        return this;
    }
}

