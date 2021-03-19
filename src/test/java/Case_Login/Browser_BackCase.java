package Case_Login;


import Test_Login.Browser_Back;
import io.appium.java_client.android.AndroidDriver;

public class Browser_BackCase {
    public Browser_BackCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BrowserBackTestCase() {

        Browser_Back BB = new Browser_Back(driver);

        try {
            BB.BrowserBackTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
