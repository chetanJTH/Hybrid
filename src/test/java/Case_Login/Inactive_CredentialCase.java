package Case_Login;

import Test_Login.Inactive_Credential;
import io.appium.java_client.android.AndroidDriver;

public class Inactive_CredentialCase {
    public Inactive_CredentialCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void InactiveCredTestCase() {

        Inactive_Credential IC = new Inactive_Credential(driver);

        try {
            IC.InactiveCredTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
