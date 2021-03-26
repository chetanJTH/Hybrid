package Case_ParentalControl;

import Test_ParentalControl.Block_Category;
import io.appium.java_client.android.AndroidDriver;

public class Block_CategoryCase {
    public Block_CategoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlockCategoryTestCase() {

        Block_Category P = new Block_Category(driver);

        try {
            P.BlockCategoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
