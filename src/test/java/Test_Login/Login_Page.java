package Test_Login;

import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Login_Page extends Home {
    public Login_Page(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;


    @Test
    public void LoginPageTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Login Page ");
        test.assignCategory("Regression");

        //TC0044

        HomePageLogin();

        EmailAddress();

        if(isScreenShot()) {
            captureScreenShot();
        }

        EnterPassword();

        if(isScreenShot()) {
            captureScreenShot();
        }

        LoginButtonDisplay();

    }



//    public void HomePageRegister() {
//        loginFactory L = new loginFactory(this.driver);
//        if (L.RegisterButton != null) {
//            L.RegisterButton.isEnabled();
//            Log.addLog("Login Page is visible");
//            test.log(Status.INFO, "Login Page is visible");
//        } else {
//            Log.addLog("Login Page is Not visible");
//            test.log(Status.FAIL, "Login Page is Not visible");
//        }
//    }

    public void HomePageLogin() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.click();
            Log.addLog("Login button is clicked");
            test.log(Status.INFO, "Login button is clicked");
        } else {
            Log.addLog("Login button is not visible");
            test.log(Status.FAIL, "Login button is not visible");
        }
    }

    public void EmailAddress() {
        loginFactory L = new loginFactory(this.driver);
        if (L.EmailAddress != null) {
            L.EmailAddress.isDisplayed();
            Log.addLog("Email address field displayed");
            test.log(Status.INFO, "Email address field displayed");
        } else {
            Log.addLog("Email address field not visible");
            test.log(Status.FAIL, "Email address field not visible");
        }
    }

    public void EnterPassword() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Password != null) {
            L.Password.isDisplayed();
            Log.addLog("Password filed displayed");
            test.log(Status.INFO, "Password filed displayed");
        } else {
            Log.addLog("Password field not visible");
            test.log(Status.FAIL, "Password field not visible");
        }
    }

    public void LoginButtonDisplay() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.isDisplayed();
            Log.addLog("Login button is displayed");
            test.log(Status.INFO, "Login button is displayed");
        } else {
            Log.addLog("Login button is not visible");
            test.log(Status.FAIL, "Login button is not visible");
        }
    }

    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
