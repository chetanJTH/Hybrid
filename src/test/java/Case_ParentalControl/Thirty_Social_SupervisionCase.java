package Case_ParentalControl;

import Test_ParentalControl.Thirty_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Thirty_Social_SupervisionCase {
    public Thirty_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ThirtySocialSupervisionTestCase() {

        Thirty_Social_Supervision P = new Thirty_Social_Supervision(driver);

        try {
            P.ThirtySocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
