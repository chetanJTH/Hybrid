package Case_ParentalControl;

import Test_ParentalControl.Check_WebHistory;
import io.appium.java_client.android.AndroidDriver;

public class Check_WebHistoryCase {
    public Check_WebHistoryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckWebHistoryTestCase() {

        Check_WebHistory P = new Check_WebHistory(driver);

        try {
            P.CheckWebHistoryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
