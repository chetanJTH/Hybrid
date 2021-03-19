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

public class Log_Out extends Home {
    public Log_Out(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void LogoutTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Log Out");
        test.assignCategory("Regression");

        //TC2063

        LogoutButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        ConfirmButton();

        if(isScreenShot()) {
            captureScreenShot();
        }




    }



    public void LogoutButton() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Logout != null) {
            L.Logout.click();
            Log.addLog("Logout button is clicked");
            test.log(Status.INFO, "Logout button is clicked");
        } else {
            Log.addLog("Logout button is not visible");
            test.log(Status.FAIL, "Logout button is not visible");
        }
    }

    public void ConfirmButton() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Confirm != null) {
            L.Confirm.click();
            Log.addLog("Confirm button is clicked");
            test.log(Status.INFO, "Confirm button is clicked");
        } else {
            Log.addLog("Confirm button is not visible");
            test.log(Status.FAIL, "Confrim button is not visible");
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
