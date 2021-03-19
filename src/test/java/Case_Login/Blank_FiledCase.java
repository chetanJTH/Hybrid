package Case_Login;

import Test_Login.Blank_Fields;
import io.appium.java_client.android.AndroidDriver;

public class Blank_FiledCase {
    public Blank_FiledCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BothBlankFiledTestCase() {

        Blank_Fields BB = new Blank_Fields(driver);

        try {
            BB.BothBlankFiledTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
