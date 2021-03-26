package Case_ParentalControl;

import Test_ParentalControl.Parental_ControlPage;
import io.appium.java_client.android.AndroidDriver;

public class Parental_ControlPageCase {
    public Parental_ControlPageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ParentalControlPageTestCase() {

        Parental_ControlPage P = new Parental_ControlPage(driver);

        try {
            P.ParentalControlPageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
