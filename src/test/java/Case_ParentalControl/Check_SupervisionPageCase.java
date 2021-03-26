package Case_ParentalControl;

import Test_ParentalControl.Check_SupervisionPage;
import io.appium.java_client.android.AndroidDriver;

public class Check_SupervisionPageCase {
    public Check_SupervisionPageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckSupervisionPageTestCase() {

        Check_SupervisionPage P = new Check_SupervisionPage(driver);

        try {
            P.CheckSupervisionPageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
