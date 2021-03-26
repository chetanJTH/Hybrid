package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import extentreports.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;

public class Check_DeviceCategory extends Home {
    public Check_DeviceCategory(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void CheckDeviceCategoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check device category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String scrollableList = "xunison.com.smarthomeapp:id/devices_rv";
        String elClassName = "android.widget.TextView";
        String el = "realme-C11";



        if (P.WebCategory != null) {
            Log.addLog("Category displayed");
            List<MobileElement> allCategory=driver.findElementsByXPath("//*[@resource-id='xunison.com.smarthomeapp:id/title_tv']");

            for (MobileElement mobileElement : allCategory) {
                Log.addLog(mobileElement.getText());
            }

        } else {
            Log.addLog("No category found");
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


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
