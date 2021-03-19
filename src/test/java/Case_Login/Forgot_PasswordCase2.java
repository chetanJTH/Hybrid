package Case_Login;

import Test_Login.Forgot_Password2;
import io.appium.java_client.android.AndroidDriver;

public class Forgot_PasswordCase2 {
    public Forgot_PasswordCase2(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ForgotPasswordTestCase() {

        Forgot_Password2 FP = new Forgot_Password2(driver);

        try {
            FP.ForgotPasswordTest2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
