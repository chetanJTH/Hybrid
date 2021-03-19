package Case_Login;

import Test_Login.Blank_Email;
import io.appium.java_client.android.AndroidDriver;

public class Blank_EmailCase {
    public Blank_EmailCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BlankEmailTestCase() {

        Blank_Email BE = new Blank_Email(driver);

        try {
           BE.BlankEmailTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
