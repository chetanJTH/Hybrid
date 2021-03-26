package Case_ParentalControl;

import Test_ParentalControl.Check_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Check_Social_SupervisionCase {
    public Check_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckSocialSupervisionTesCase() {

        Check_Social_Supervision P = new Check_Social_Supervision(driver);

        try {
            P.CheckSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
