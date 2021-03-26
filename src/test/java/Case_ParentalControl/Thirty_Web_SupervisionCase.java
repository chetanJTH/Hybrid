package Case_ParentalControl;

import Test_ParentalControl.Thirty_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Thirty_Web_SupervisionCase {
    public Thirty_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ThirtyWebSupervisionTestCase() {

        Thirty_Web_Supervision P = new Thirty_Web_Supervision(driver);

        try {
            P.ThirtyWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
