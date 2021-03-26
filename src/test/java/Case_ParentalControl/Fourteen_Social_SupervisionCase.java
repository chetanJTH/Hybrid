package Case_ParentalControl;

import Test_ParentalControl.Fourteen_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Fourteen_Social_SupervisionCase {
    public Fourteen_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FourteenSocialSupervisionTestCase() {

        Fourteen_Social_Supervision P = new Fourteen_Social_Supervision(driver);

        try {
            P.FourteenSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
