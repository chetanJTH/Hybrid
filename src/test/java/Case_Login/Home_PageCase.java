package Case_Login;

import Test_Login.Home_Page;
import io.appium.java_client.android.AndroidDriver;

public class Home_PageCase {
    public Home_PageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void HomePageTestCase() {

        Home_Page HP = new Home_Page(driver);

        try {
            HP.HomePageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
