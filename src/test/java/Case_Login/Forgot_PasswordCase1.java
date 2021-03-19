package Case_Login;

import Test_Login.Forgot_Password1;
import io.appium.java_client.android.AndroidDriver;

public class Forgot_PasswordCase1 {
    public Forgot_PasswordCase1(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ForgotPasswordTestCase() {

        Forgot_Password1 FP = new Forgot_Password1(driver);

        try {
            FP.ForgotPasswordTest1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
