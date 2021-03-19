package Case_Login;

import Test_Login.Wifi_Off;
import io.appium.java_client.android.AndroidDriver;

public class Wifi_OffCase {
    public Wifi_OffCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void WifiOffTestCase() {

        Wifi_Off WO = new Wifi_Off(driver);

        try {
            WO.WifiOffTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
