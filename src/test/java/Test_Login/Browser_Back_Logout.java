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

public class Browser_Back_Logout extends Home {
    public Browser_Back_Logout(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void BrowserBackLogoutCase() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Log Out");
        test.assignCategory("Regression");

        //TC0056

        driver.navigate().back();
        Log.addLog("Mobile back button has been clicked");
        test.log(Status.INFO, "Mobile back button has been clicked");

        driver.launchApp();
        Log.addLog("App has been relaunched");
        test.log(Status.INFO, "App has been relaunched");

        if(isScreenShot()) {
            captureScreenShot();
        }

        HomePage();

        if(isScreenShot()) {
            captureScreenShot();
        }


    }



    public void HomePage() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.isDisplayed();
            Log.addLog("Login page is visible");
            test.log(Status.INFO, "Login page is visible");
        } else {
            Log.addLog("Login page is not visible");
            test.log(Status.FAIL, "Login page is not visible");
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
