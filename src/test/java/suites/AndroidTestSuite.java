package suites;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.android.AndroidMyListPageObject;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.android.AndroidSearchPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AndroidArticlePageObject.class,
        AndroidMyListPageObject.class,
        AndroidNavigationUI.class,
        MyListsTest.class,
        AndroidSearchPageObject.class
})

public class AndroidTestSuite {
}
