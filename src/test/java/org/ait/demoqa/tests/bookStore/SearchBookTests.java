package org.ait.demoqa.tests.bookStore;

import org.ait.demoqa.data.BookData;
import org.ait.demoqa.pages.bookStore.BookStorePage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.bookStore.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.data.UserData;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest() {
        new BookStorePage(driver)
                .enterBookName(BookData.BOOK_NAME)
                .verifyBookName(BookData.BOOK_NAME);
    }

    @Test
    public void addToCollectionTest() {
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).loginPositive(UserData.USER_NAME,UserData.USER_PASSWORD);
        new BookStorePage(driver).enterBookName(BookData.BOOK_NAME)
                .clickOnBookName()
                .addToCollection();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).verifyBookName(BookData.BOOK_NAME).deleteBook();
    }
}