package Case_ParentalControl;

import Test_ParentalControl.Block_Website;
import io.appium.java_client.android.AndroidDriver;

public class Block_WebsiteCase {
    public Block_WebsiteCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlockWebsiteTestCase() {

        Block_Website P = new Block_Website(driver);

        try {
            P.BlockWebsiteTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
