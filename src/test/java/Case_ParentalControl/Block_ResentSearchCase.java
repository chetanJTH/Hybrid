package Case_ParentalControl;


import Test_ParentalControl.Block_ResentSearch;
import io.appium.java_client.android.AndroidDriver;

public class Block_ResentSearchCase {
    public Block_ResentSearchCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlockResentSearchTestCase() {

        Block_ResentSearch P = new Block_ResentSearch(driver);

        try {
            P.BlockResentSearchTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
