package Case_ParentalControl;

import Test_ParentalControl.Fourteen_Device_Social_Supervision;
import io.appium.java_client.android.AndroidDriver;

public class Fourteen_Device_Social_SupervisionCase {
    public Fourteen_Device_Social_SupervisionCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FourteenDeviceSocialSupervisionTestCase() {

        Fourteen_Device_Social_Supervision P = new Fourteen_Device_Social_Supervision(driver);

        try {
            P.FourteenDeviceSocialSupervisionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
