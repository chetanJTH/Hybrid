package Case_ParentalControl;

import Test_ParentalControl.Allowed_Website;
import io.appium.java_client.android.AndroidDriver;

public class Allowed_WebsiteCase {
    public Allowed_WebsiteCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AllowedWebsiteTestCase() {

        Allowed_Website P = new Allowed_Website(driver);

        try {
            P.AllowedWebsiteTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
