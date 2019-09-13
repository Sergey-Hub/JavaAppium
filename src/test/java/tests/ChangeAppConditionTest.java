package tests;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTest extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults() {

        if(Platform.getInstance().isMW()){
            return;
        }
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject((AppiumDriver) driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        String title_before_rotation = ArticlePageObject.getArticleTitle();

        rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Title of the article has been changed after rotation",
                title_before_rotation,
                title_after_rotation
        );

        rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Title of the article has been changed after rotation",
                title_before_rotation,
                title_after_second_rotation
        );

    }

    @Test
    public void testCheckSearchArticleInBackground() {

        if(Platform.getInstance().isMW()){
            return;
        }
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        backgroundApp(5);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

}
