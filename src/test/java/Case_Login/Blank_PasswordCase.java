package Case_Login;

import Test_Login.Blank_Password;
import io.appium.java_client.android.AndroidDriver;

public class Blank_PasswordCase {
    public Blank_PasswordCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlankPasswordTestCase() {

        Blank_Password BP = new Blank_Password(driver);

        try {
            BP.BlankPasswordTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
