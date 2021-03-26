package Case_ParentalControl;

import Test_ParentalControl.Check_InternetAccess;
import io.appium.java_client.android.AndroidDriver;

public class Check_InternetAccessCase {
    public Check_InternetAccessCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckInternetAccessTestCase() {

        Check_InternetAccess P = new Check_InternetAccess(driver);

        try {
            P.CheckInternetAccessTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
