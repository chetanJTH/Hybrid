package Case_ParentalControl;

import Test_ParentalControl.Week_Device_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Week_Device_Social_SupervisionCase {
    public Week_Device_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void WeekDeviceSocialSupervisionTestCase() {

        Week_Device_Social_Supervision P = new Week_Device_Social_Supervision(driver);

        try {
            P.WeekDeviceSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
