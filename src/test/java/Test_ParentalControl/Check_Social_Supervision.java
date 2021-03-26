package Test_ParentalControl;

import PageFactory.ParentalFactory;
import PageFactory.SmartHomeFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Check_Social_Supervision extends Home {
    public Check_Social_Supervision(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    //TC0218

    @Test
    public void CheckSocialSupervisionTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check web supervision page");
        test.assignCategory("Regression");
        SmartHomeFactory G = new SmartHomeFactory(driver);
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String scrollableList = "xunison.com.smarthomeapp:id/scroll_view";
        String elClassName = "android.widget.TextView";
        String el = "Web Supervision";

        driver.findElementByXPath("//android.widget.TextView[@text='router v2']").click();

        wait.until(ExpectedConditions.elementToBeClickable(G.AddTool));

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.findElement(By.className("android.widget.ImageButton")).click();
        Log.addLog("Menu button is clickable");
        test.log(Status.INFO, "Menu button is clickable");

        if(isScreenShot()) {
            captureScreenShot();
        }

        ParentalControlButton();

        if(isScreenShot()) {
            captureScreenShot();
        }



        if (isScreenShot()) {
            captureScreenShot();
        }

        P.Supervision.click();

        wait.until(ExpectedConditions.elementToBeClickable(P.SocialSupervision));

        P.SocialSupervision.click();
    }

    private void findElement(String id, String className, String text) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).click();

            Log.addLog("Device list display");
        } catch (Exception e) {
            Log.addLog("Device does not display");
        }

    }

    public void SocialSupervisionPage() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.SocialSupervision != null) {
            P.SocialSupervision.click();
            Log.addLog("Social supervision button clicked");
            test.log(Status.INFO, "Social supervision button clicked");
        } else {
            Log.addLog("Social supervision button not found");
            test.log(Status.FAIL, "Social supervision button not found");
        }
    }


    public static void captureScreenShot() {
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ParentalControlButton() {
        SmartHomeFactory G = new SmartHomeFactory(driver);
        if (G.ParentalControl != null) {
            G.ParentalControl.click();
            Log.addLog("Parental control button is clicked");
            test.log(Status.INFO, "Parental control button is clicked");
        } else {
            Log.addLog("Parental control button is not visible");
            test.log(Status.FAIL, "Parental control button is not visible");
        }
    }

}
