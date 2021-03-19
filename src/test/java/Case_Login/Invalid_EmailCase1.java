package Case_Login;

import Test_Login.Invalid_Email1;
import io.appium.java_client.android.AndroidDriver;

public class Invalid_EmailCase1 {
    public Invalid_EmailCase1(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void InvalidEmailTestCase1() {

        Invalid_Email1 IE = new Invalid_Email1(driver);

        try {
            IE.InvalidEmailTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
