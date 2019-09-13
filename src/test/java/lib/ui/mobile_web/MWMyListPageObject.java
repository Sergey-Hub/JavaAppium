package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TMP = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}']";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}']/../../div[contains(@class,'watched')]";
    }

    public MWMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
