package Case_ParentalControl;

import Test_ParentalControl.Check_SocialHistory;
import io.appium.java_client.android.AndroidDriver;

public class Check_SocialHistoryCase {
    public Check_SocialHistoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckSocialHistoryTestCase() {

        Check_SocialHistory P = new Check_SocialHistory(driver);

        try {
            P.CheckSocialHistoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
