package Case_Login;

import Test_Login.Verify_Logout;
import Test_Login.Welcome_Page;
import io.appium.java_client.android.AndroidDriver;

public class Verify_LogoutCase {
    public Verify_LogoutCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void VerifyLogoutTestCase() {

        Verify_Logout VL = new Verify_Logout(driver);

        try {
            VL.VerifyLogoutTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
