package Case_ParentalControl;

import Test_ParentalControl.Search_Twitter;
import io.appium.java_client.android.AndroidDriver;

public class Search_TwitterCase {
    public Search_TwitterCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void SearchTwitterTestCase() {

        Search_Twitter P = new Search_Twitter(driver);

        try {
            P.SearchTwitterTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
