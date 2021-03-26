package Case_ParentalControl;

import Test_ParentalControl.Today_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Today_Web_SupervisionCase {
    public Today_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void TodayWebSupervisionTestCase() {

        Today_Web_Supervision P = new Today_Web_Supervision(driver);

        try {
            P.TodayWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
