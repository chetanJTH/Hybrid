package Case_Login;

import Test_Login.Valid_Login;
import io.appium.java_client.android.AndroidDriver;

public class Valid_LoginCase {
    public Valid_LoginCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ValidLoginTestCase() {

        Valid_Login VL = new Valid_Login(driver);

        try {
            VL.AppLoginValid();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
