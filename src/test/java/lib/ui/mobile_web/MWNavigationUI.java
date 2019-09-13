package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {

    static {
        MY_LISTS_LINK = "css:a[data-event-name='watchlist']";
        OPEN_NAVIGATION = "css:#mv-mf-main-menu-button";
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

}