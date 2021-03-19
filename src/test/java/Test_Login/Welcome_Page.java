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


public class Welcome_Page extends Home {
    public Welcome_Page(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    @Test
    public void HomeLogin() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Application Login Page");
        test.assignCategory("Regression");


        //TC0043

        HomePageRegister();

        if(isScreenShot()) {
            captureScreenShot();
        }

        HomePageLogin();

        Log.addLog("Login page displayed");


    }



    public void HomePageRegister() {
        loginFactory L = new loginFactory(this.driver);
        if (L.RegisterButton != null) {
            if(L.RegisterButton.isDisplayed())
                Log.addLog("Register button is displayed");
                test.log(Status.INFO, "Register button is displayed");
        } else {
                Log.addLog("Register button is not displayed");
                test.log(Status.FAIL, "Register button is not displayed");
        }
    }

    public void HomePageLogin() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.isDisplayed();
            Log.addLog("Login button is displayed");
            test.log(Status.INFO, "Login button is displayed");
        } else {
            Log.addLog("Login button is not displayed");
            test.log(Status.FAIL, "Login button is not displayed");
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
