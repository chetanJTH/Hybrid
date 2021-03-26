package Case_ParentalControl;

import Test_ParentalControl.Access_BlockCategory;
import io.appium.java_client.android.AndroidDriver;

public class Access_BlockCategoryCase {
    public Access_BlockCategoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AccessBlockCategoryTestCase() {

        Access_BlockCategory P = new Access_BlockCategory(driver);

        try {
            P.AccessBlockCategoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
