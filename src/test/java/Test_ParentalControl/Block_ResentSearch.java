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
import java.util.concurrent.TimeUnit;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Block_ResentSearch extends Home {
    public Block_ResentSearch(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0233

    @Test
    public void BlockResentSearchTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block resent search URL");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);

        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        BlockWebsiteButton();

        BlockUdemy();

        ChromeButton();

        driver.context("WEBVIEW_chrome");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        try {
            driver.get("http://udemy.com");
        } catch (Exception t) {
            t.printStackTrace();
            Log.addLog("url is blocked" + t.getMessage());
            if (t.getMessage().contains("timeout")) {
                Log.addLog("url is blocked");
            }
        }

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.context("NATIVE_APP");
        Log.addLog("Context changed to Native");

        driver.launchApp();

    }

    public void BlockWebsiteButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.BlockWebsite != null) {
            P.BlockWebsite.click();
            Log.addLog("Block website field clicked");
            test.log(Status.INFO, "Block website field clicked");
        } else {
            Log.addLog("Block website field not visible");
            test.log(Status.FAIL, "Block website field not visible");
        }
    }

    public void BlockUdemy() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddWebsite != null) {
            P.AddWebsite.sendKeys("www.udemy.com");
            P.AddBlockWeb.click();
            Log.addLog("Website has been blocked");
            test.log(Status.INFO, "Website has been blocked");
        } else {
            Log.addLog("Add website field not visible");
            test.log(Status.FAIL, "Add website field not visible");
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


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
