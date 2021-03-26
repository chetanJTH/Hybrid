package Case_ParentalControl;

import Test_ParentalControl.Thirty_Device_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Thirty_Device_Web_SupervisionCase {
    public Thirty_Device_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ThirtyDeviceWebSupervisionTestCase() {

        Thirty_Device_Web_Supervision P = new Thirty_Device_Web_Supervision(driver);

        try {
            P.ThirtyDeviceWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
