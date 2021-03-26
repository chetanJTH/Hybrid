package Case_ParentalControl;

import Test_ParentalControl.Access_UnblockCategory;
import io.appium.java_client.android.AndroidDriver;

public class Access_UnblockCategoryCase {
    public Access_UnblockCategoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AccessUnblockCategoryTestCase() {

        Access_UnblockCategory P = new Access_UnblockCategory(driver);

        try {
            P.AccessUnblockCategoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
