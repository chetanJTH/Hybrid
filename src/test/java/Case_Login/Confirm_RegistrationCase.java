package Case_Login;

import Test_Login.Blank_Password;
import Test_Login.Confirm_Registration;
import io.appium.java_client.android.AndroidDriver;

public class Confirm_RegistrationCase {
    public Confirm_RegistrationCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ConfirmRegistrationTestCase() {

        Confirm_Registration BP = new Confirm_Registration(driver);

        try {
            BP.ConfirmRegistrationTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
