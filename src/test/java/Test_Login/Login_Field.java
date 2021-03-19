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

public class Login_Field extends Home {
    public Login_Field(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;


    @Test
    public void LoginFieldTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Login fields");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);

        //TC0045

        ShowPassword();

        ForgotpasswordLink();

        AccountLink();

        CreateAccount();

        if(isScreenShot()) {
            captureScreenShot();
        }


    }



    public void ShowPassword() {
        loginFactory L = new loginFactory(this.driver);
        if (L.ShowPassword != null) {
            L.ShowPassword.isEnabled();
            Log.addLog("Show password button is displayed");
            test.log(Status.INFO, "Show password button is displayed");
        } else {
            Log.addLog("Show password button is displayed");
            test.log(Status.FAIL, "Show password button is displayed");
        }
    }

    public void ForgotpasswordLink() {
        loginFactory L = new loginFactory(this.driver);
        if (L.ForgotPassword != null) {
            L.ForgotPassword.isDisplayed();
            Log.addLog("Forgot password link is displayed");
            test.log(Status.INFO, "Forgot password link is displayed");
        } else {
            Log.addLog("Forgot password link is not displayed");
            test.log(Status.FAIL, "Forgot password link is not displayed");
        }
    }

    public void AccountLink() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Account != null) {
            L.Account.isDisplayed();
            Log.addLog("Don't have account link is displayed");
            test.log(Status.INFO, "Don't have account link is displayed");
        } else {
            Log.addLog("Don't have account link is not found");
            test.log(Status.FAIL, "Don't have account link is not found");
        }
    }

    public void CreateAccount() {
        loginFactory L = new loginFactory(this.driver);
        if (L.CreateAccount != null) {
            L.CreateAccount.isDisplayed();
            Log.addLog("Create account field is displayed");
            test.log(Status.INFO, "Create account field is displayed");
        } else {
            Log.addLog("Create account field is not found");
            test.log(Status.FAIL, "Create account field is not found");
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
