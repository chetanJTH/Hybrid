package Case_Login;


import Test_Login.Browser_Back_Logout;
import io.appium.java_client.android.AndroidDriver;

public class Browser_Back_LogoutCase {
    public Browser_Back_LogoutCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void BrowserBackLogoutTestCase() {

        Browser_Back_Logout BB = new Browser_Back_Logout(driver);

        try {
            BB.BrowserBackLogoutCase();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
