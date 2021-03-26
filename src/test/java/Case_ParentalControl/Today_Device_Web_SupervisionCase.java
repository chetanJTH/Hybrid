package Case_ParentalControl;

import Test_ParentalControl.Today_Device_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Today_Device_Web_SupervisionCase {
    public Today_Device_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void TodayDeviceWebSupervisionTestCase() {

        Today_Device_Web_Supervision P = new Today_Device_Web_Supervision(driver);

        try {
            P.TodayDeviceWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
