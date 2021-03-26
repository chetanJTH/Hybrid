package Test_ParentalControl;

import com.aventstack.extentreports.ExtentTest;
import extentreports.ExtentReport;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Failed_Attempt extends Home {
    public Failed_Attempt(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0234

    @Test
    public void FailedAttemptTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check website log status");
        test.assignCategory("Regression");

        String elClassName = "android.widget.TextView";
        String scrollableID = "xunison.com.smarthomeapp:id/web_activity_rv";
        String log = "Attempt to visit blocked website";


        findElement(scrollableID,elClassName,log);



        if(isScreenShot()) {
            captureScreenShot();
        }


    }

    private void findElement (String id, String className, String text) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).isDisplayed();

            Log.addLog("Log displayed");
        } catch (Exception e) {
            Log.addLog("Log does not display");
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
