package Case_Login;

import Test_Login.Login_Page;
import io.appium.java_client.android.AndroidDriver;

public class Login_PageCase {
    public Login_PageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void LoginPageTestCase() {

        Login_Page LP = new Login_Page(driver);

        try {
            LP.LoginPageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
