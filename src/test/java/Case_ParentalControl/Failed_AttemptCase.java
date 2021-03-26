package Case_ParentalControl;

import Test_ParentalControl.Failed_Attempt;
import io.appium.java_client.android.AndroidDriver;

public class Failed_AttemptCase {
    public Failed_AttemptCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FailedAttemptTestCase() {

        Failed_Attempt P = new Failed_Attempt(driver);

        try {
            P.FailedAttemptTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
