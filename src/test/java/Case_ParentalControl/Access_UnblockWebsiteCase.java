package Case_ParentalControl;

import Test_ParentalControl.Access_UnblockWebsite;
import io.appium.java_client.android.AndroidDriver;

public class Access_UnblockWebsiteCase {
    public Access_UnblockWebsiteCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AccessUnblockWebsiteTestCase() {

        Access_UnblockWebsite P = new Access_UnblockWebsite(driver);

        try {
            P.AccessUnblockWebsiteTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
