package Case_ParentalControl;


import Test_ParentalControl.Unblock_Website;
import io.appium.java_client.android.AndroidDriver;

public class Unblock_WebsiteCase {
    public Unblock_WebsiteCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UnblockWebsiteCaseTest() {

        Unblock_Website P = new Unblock_Website(driver);

        try {
            P.UnblockWebsiteTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
