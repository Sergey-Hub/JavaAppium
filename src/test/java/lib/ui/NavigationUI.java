package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject {

    private static final String
    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;


    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
    public void openNavigation(){
        if (Platform.getInstance().isMW()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "CANNOT FIND NAVIGATION BUTTON", 5);
        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }


}
