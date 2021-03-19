package Case_Login;

import Test_Login.Log_Out;
import io.appium.java_client.android.AndroidDriver;

public class Log_OutCase {
    public Log_OutCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void LogOutTestCase() {

        Log_Out LO = new Log_Out(driver);

        try {
            LO.LogoutTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
