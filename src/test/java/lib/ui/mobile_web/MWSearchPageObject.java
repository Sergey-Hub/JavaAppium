package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_STRING_TPL = "xpath://div[contains(@class, 'wikipedia-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_LIST_ITEM_TITLE = "xpath://div[contains(@class, 'page-heading')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_BY_STRING_AND_DESCRIPTION_TPL = "xpath://div[contains(@class, 'page-heading')][contains(text(),'{SUBSTRING}')][contains(text(),'{DESCRIPTION}')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
