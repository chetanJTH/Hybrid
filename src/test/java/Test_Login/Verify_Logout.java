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

public class Verify_Logout extends Home {
    public Verify_Logout(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void VerifyLogoutTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Log Out");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(driver);

        //TC0058

        L.RegisterButton.isDisplayed();
        Log.addLog("Register button is displayed");
        test.log(Status.INFO, "Register button is displayed");

        L.LoginButton.isDisplayed();
        Log.addLog("Login button is displayed");
        test.log(Status.INFO, "Login button is displayed");


        if(isScreenShot()) {
            captureScreenShot();
        }



    }




    public static void captureScreenShot(){
        String screenShotPath = Screenshot("Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
