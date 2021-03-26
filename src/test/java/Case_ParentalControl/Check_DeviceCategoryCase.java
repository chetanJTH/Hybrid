package Case_ParentalControl;

import Test_ParentalControl.Check_DeviceCategory;
import io.appium.java_client.android.AndroidDriver;

public class Check_DeviceCategoryCase {
    public Check_DeviceCategoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckDeviceCategoryTestCase() {

        Check_DeviceCategory P = new Check_DeviceCategory(driver);

        try {
            P.CheckDeviceCategoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
