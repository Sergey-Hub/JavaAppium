
package tests;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.ios.MWNavigationUI;
import lib.ui.ios.iOSNavigationUI;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String
            login = "Sergey1405",
            password = "q1w2e3r44r3e2w1q";

    @Test
    public MWNavigationUI testSaveFirstArticleToMyList() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject((AppiumDriver) driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();

        String name_of_folder = "Learning programming";

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();

        }
        if (Platform.getInstance().isMW()) {
            AutorizationPageObject Auth = new AutorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);

        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveFirstTwoArticlesToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject((AppiumDriver) driver);
        String search_line = "Java";
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Programming language");
        String title_before_adding_article_to_reading_list = ArticlePageObject.getArticleTitle();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        ArticlePageObject.addArticleToExistingList(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
        SearchPageObject.clickByArticleWithSubstring("programming language");
        String title_after_adding_article_to_reading_list = ArticlePageObject.getArticleTitle();
        assertEquals(
                "Titles of the article before adding to the list and after are different",
                title_before_adding_article_to_reading_list,
                title_after_adding_article_to_reading_list
        );
    }

}

