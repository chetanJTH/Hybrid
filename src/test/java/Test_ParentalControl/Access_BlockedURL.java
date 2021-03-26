package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import static Test_ParentalControl.Block_URL.storeUrl;
import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Access_BlockedURL extends Home {
    public Access_BlockedURL(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0232

    @Test
    public void AccessBlockedURLTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Access block website");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);



        driver.navigate().back();

        DeviceButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        ChromeButton();

        wait.until(ExpectedConditions.elementToBeClickable(P.ChromeHome));

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);

        }

        ChromeHome();

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.context("WEBVIEW_chrome");


        try {
            driver.get("http://"+storeUrl);
        } catch (Exception t) {
            t.printStackTrace();
            Log.addLog("url is blocked" + t.getMessage());
            if (t.getMessage().contains("timeout")) {
                Log.addLog("url is blocked");
            }
        }

        driver.context("NATIVE_APP");
        Log.addLog("Context changed to Native");

        driver.launchApp();

    }

    public void ChromeHome() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.ChromeHome != null) {
            P.ChromeHome.click();
            Log.addLog("Home button clicked");
            test.log(Status.INFO, "Home button clicked");
        } else {
            Log.addLog("Home button found");
            test.log(Status.FAIL, "Home button found");
        }
    }

    public void ChromeButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.ChromeButton != null) {
            P.ChromeButton.click();
            Log.addLog("Chrome button clicked");
            test.log(Status.INFO, "Chrome button clicked");
        } else {
            Log.addLog("Chrome button found");
            test.log(Status.FAIL, "Chrome button found");
        }
    }

    public void DeviceButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.Devices != null) {
            P.Devices.click();
            Log.addLog("Device button clicked");
            test.log(Status.INFO, "Device website button clicked");
        } else {
            Log.addLog("Device button not visible");
            test.log(Status.FAIL, "Device button not visible");
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
