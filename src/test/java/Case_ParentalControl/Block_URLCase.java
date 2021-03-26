package Case_ParentalControl;

import Test_ParentalControl.Block_URL;
import io.appium.java_client.android.AndroidDriver;

public class Block_URLCase {
    public Block_URLCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlockURLTestCase() {

        Block_URL P = new Block_URL(driver);

        try {
            P.BlockURLTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
