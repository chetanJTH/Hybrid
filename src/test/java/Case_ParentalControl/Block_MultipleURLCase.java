package Case_ParentalControl;

import Test_ParentalControl.Block_MultipleURL;
import io.appium.java_client.android.AndroidDriver;

public class Block_MultipleURLCase {
    public Block_MultipleURLCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlockMultipleURLTestCase() {

        Block_MultipleURL P = new Block_MultipleURL(driver);

        try {
            P.BlockMultipleURLTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
