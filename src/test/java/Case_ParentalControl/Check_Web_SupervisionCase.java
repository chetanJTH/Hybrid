package Case_ParentalControl;

import Test_ParentalControl.Check_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Check_Web_SupervisionCase {
    public Check_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckWebSupervisionTestCase() {

        Check_Web_Supervision P = new Check_Web_Supervision(driver);

        try {
            P.CheckWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
