package Case_ParentalControl;

import Test_ParentalControl.Week_Device_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Week_Device_Web_SupervisionCase {
    public Week_Device_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void WeekDeviceWebSupervisionTestCase() {

        Week_Device_Web_Supervision P = new Week_Device_Web_Supervision(driver);

        try {
            P.WeekDeviceWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
