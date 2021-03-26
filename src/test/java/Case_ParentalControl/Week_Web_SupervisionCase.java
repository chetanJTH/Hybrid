package Case_ParentalControl;

import Test_ParentalControl.Week_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Week_Web_SupervisionCase {
    public Week_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void WeekWebSupervisionTestCase() {

        Week_Web_Supervision P = new Week_Web_Supervision(driver);

        try {
            P.WeekWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
