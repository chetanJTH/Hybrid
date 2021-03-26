package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Thirty_Web_Supervision extends Home {
    public Thirty_Web_Supervision(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void ThirtyWebSupervisionTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("30 days web supervision");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String scrollableList = "xunison.com.smarthomeapp:id/devices_rv";
        String elClassName = "android.widget.TextView";
        String el = "All Devices";



        findElement(scrollableList,el);

        driver.findElementByXPath("//android.widget.TextView[@text='All Devices']").click();

        if(isScreenShot()) {
            captureScreenShot();
        }

        MonthHistory();

        if(isScreenShot()) {
            captureScreenShot();
        }

    }



    private void findElement (String id, String text) {
        try {
//            driver.findElement(MobileBy.AndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
//                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).click();

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
                    + "resourceId(\"" + id + "\"))"
                    + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + text + "\"))");

            Log.addLog("Device list display");
        } catch (Exception e) {
            Log.addLog("Device does not display");
        }

    }

    public void MonthHistory() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.ThirtyDays != null) {
            P.ThirtyDays.click();
            Log.addLog("30 days button clicked");
            test.log(Status.INFO, "30 days button clicked");
        } else {
            Log.addLog("30 days button not found");
            test.log(Status.FAIL, "30 days button not found");
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
