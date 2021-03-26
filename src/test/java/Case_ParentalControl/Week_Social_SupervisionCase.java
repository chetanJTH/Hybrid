package Case_ParentalControl;

import Test_ParentalControl.Week_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Week_Social_SupervisionCase {
    public Week_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void WeekSocialSupervisionTestCase() {

        Week_Social_Supervision P = new Week_Social_Supervision(driver);

        try {
            P.WeekSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
