package Case_Login;

import Test_Login.Login_Field;
import io.appium.java_client.android.AndroidDriver;

public class Login_FieldCase {
    public Login_FieldCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void LoginFieldTestCase() {

        Login_Field LF = new Login_Field(driver);

        try {
            LF.LoginFieldTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
