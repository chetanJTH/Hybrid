package Case_ParentalControl;

import Test_ParentalControl.Access_BlockWebsite;
import io.appium.java_client.android.AndroidDriver;

public class Access_BlockWebsiteCase {
    public Access_BlockWebsiteCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AccessBlockWebsiteTestCase() {

        Access_BlockWebsite P = new Access_BlockWebsite(driver);

        try {
            P.AccessBlockWebsiteTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
