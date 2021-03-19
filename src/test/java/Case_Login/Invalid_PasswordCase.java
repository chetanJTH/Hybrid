package Case_Login;

import Test_Login.Invalid_Password;
import io.appium.java_client.android.AndroidDriver;

public class Invalid_PasswordCase {
    public Invalid_PasswordCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void InvalidPasswordTestCase() {

        Invalid_Password IC = new Invalid_Password(driver);

        try {
            IC.InvalidPasswordTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
