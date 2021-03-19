package Case_Login;

import Test_Login.Unregister_Email;
import io.appium.java_client.android.AndroidDriver;

public class Unregister_EmailCase {
    public Unregister_EmailCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UnregEmailTestCase() {

        Unregister_Email UE = new Unregister_Email(driver);

        try {
            UE.UnregEmailTest();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
