package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.MobileBy;
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
import static actions.MobileActions.isScreenShot;

public class Check_Web_Supervision extends Home {
    public Check_Web_Supervision(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void CheckWebSupervisionTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check web supervision page");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String scrollableList = "xunison.com.smarthomeapp:id/scroll_view";
        String elClassName = "android.widget.TextView";
        String el = "Web Supervision";


        findElement(scrollableList,elClassName,el);

        if(isScreenShot()) {
            captureScreenShot();
        }

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

    private void findElement (String id, String className, String text) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).click();

            Log.addLog("Device list display");
        } catch (Exception e) {
            Log.addLog("Device does not display");
        }

    }

    public void SupervisionPage() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.Supervision != null) {
            P.Supervision.click();
            Log.addLog("Supervision button clicked");
            test.log(Status.INFO, "Supervision button clicked");
        } else {
            Log.addLog("Supervision button not found");
            test.log(Status.FAIL, "Supervision button not found");
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
