package Case_ParentalControl;

import Test_ParentalControl.Unblock_Category;
import io.appium.java_client.android.AndroidDriver;

public class Unblock_CategoryCase {
    public Unblock_CategoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UnblockCategoryTestCase() {

        Unblock_Category P = new Unblock_Category(driver);

        try {
            P.UnblockCategoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
