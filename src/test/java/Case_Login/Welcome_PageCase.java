package Case_Login;

import Test_Login.Welcome_Page;
import io.appium.java_client.android.AndroidDriver;

public class Welcome_PageCase {
    public Welcome_PageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void LoginPageTestCase() {

        Welcome_Page LP = new Welcome_Page(driver);

        try {
            LP.HomeLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
