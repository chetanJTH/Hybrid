package Case_ParentalControl;

import Test_ParentalControl.Check_Device_SocialHistory;
import io.appium.java_client.android.AndroidDriver;

public class Check_Device_SocialHistoryCase {
    public Check_Device_SocialHistoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckDeviceSocialHistoryTestCase() {

        Check_Device_SocialHistory P = new Check_Device_SocialHistory(driver);

        try {
            P.CheckDeviceSocialHistoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
