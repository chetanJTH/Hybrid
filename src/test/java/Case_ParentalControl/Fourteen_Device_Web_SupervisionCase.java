package Case_ParentalControl;

import Test_ParentalControl.Fourteen_Device_Web_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Fourteen_Device_Web_SupervisionCase {
    public Fourteen_Device_Web_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FourteenDeviceWebSupervisionTestCase() {

        Fourteen_Device_Web_Supervision P = new Fourteen_Device_Web_Supervision(driver);

        try {
            P.FourteenDeviceWebSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
