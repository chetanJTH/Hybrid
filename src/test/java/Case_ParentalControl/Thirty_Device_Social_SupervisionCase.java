package Case_ParentalControl;

import Test_ParentalControl.Thirty_Device_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Thirty_Device_Social_SupervisionCase {
    public Thirty_Device_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ThirtyDeviceSocialSupervisionTestCase() {

        Thirty_Device_Social_Supervision P = new Thirty_Device_Social_Supervision(driver);

        try {
            P.ThirtyDeviceSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
