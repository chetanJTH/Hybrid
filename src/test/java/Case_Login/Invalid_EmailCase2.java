package Case_Login;

import Test_Login.Invalid_Email2;
import io.appium.java_client.android.AndroidDriver;

public class Invalid_EmailCase2 {
    public Invalid_EmailCase2(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void InvalidEmailTestCase2() {

        Invalid_Email2 IE = new Invalid_Email2(driver);

        try {
            IE.InvalidEmailTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
