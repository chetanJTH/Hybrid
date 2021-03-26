package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Access_UnblockWebsite extends Home {
    public Access_UnblockWebsite(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0233

    @Test
    public void AccessUnblockWebsiteTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block website");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);




        ChromeButton();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);

        }

        driver.context("WEBVIEW_chrome");

        driver.get("http://facebook.com");

        WebElement email = (WebElement) driver.findElement(By.name("email"));

        if (email.isDisplayed()) {
//            email.sendKeys("chetan");
            Log.addLog("URL is unblocked");
        } else  {
            Log.addLog("URL is blocked");
        }


        if(isScreenShot()) {
            captureScreenShot();
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


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
