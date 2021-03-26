package Case_ParentalControl;

import Test_ParentalControl.Access_BlockedURL;
import io.appium.java_client.android.AndroidDriver;

public class Access_BlockedURLCase {
    public Access_BlockedURLCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AccessBlockedURLTestCase() {

        Access_BlockedURL P = new Access_BlockedURL(driver);

        try {
            P.AccessBlockedURLTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
