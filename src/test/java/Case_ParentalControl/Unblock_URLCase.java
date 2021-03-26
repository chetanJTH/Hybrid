package Case_ParentalControl;

import Test_ParentalControl.Unblock_URL;
import io.appium.java_client.android.AndroidDriver;

public class Unblock_URLCase {
    public Unblock_URLCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UnblockURLTestCase() {

        Unblock_URL P = new Unblock_URL(driver);

        try {
            P.UnblockURLTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
