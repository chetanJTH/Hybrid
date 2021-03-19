package Case_Login;

import Test_Login.Invalid_Credential;
import io.appium.java_client.android.AndroidDriver;

public class Invalid_CredentialCase {
    public Invalid_CredentialCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void InvalidCredTestCase() {

        Invalid_Credential IC = new Invalid_Credential(driver);

        try {
            IC.InvalidCredTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
