package Case_ParentalControl;

import Test_ParentalControl.Parental_DeviceStatus;
import io.appium.java_client.android.AndroidDriver;

public class Parental_DeviceStatusCase {
    public Parental_DeviceStatusCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ParentalDeviceStatusTestCase() {

        Parental_DeviceStatus P = new Parental_DeviceStatus(driver);

        try {
            P.ParentalDeviceStatusTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
