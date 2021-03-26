package Case_ParentalControl;

import Test_ParentalControl.Fourteen_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Fourteen_Web_SupervisionCase {
    public Fourteen_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FourteenWebSupervisionTestCase() {

        Fourteen_Web_Supervision P = new Fourteen_Web_Supervision(driver);

        try {
            P.FourteenWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
