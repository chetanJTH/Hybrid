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
import java.util.concurrent.TimeUnit;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Access_BlockCategory extends Home {
    public Access_BlockCategory(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0232

    @Test
    public void AccessBlockCategoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);



        ChromeButton();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);

        }

        wait.until(ExpectedConditions.elementToBeClickable(P.ChromeHome));

        ChromeHome();

        driver.context("WEBVIEW_chrome");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        try {
            driver.get("http://alwaysfuncasinos.com/");
        } catch (Exception t) {
            t.printStackTrace();
            Log.addLog("category is blocked" + t.getMessage());
            if (t.getMessage().contains("timeout")) {
                Log.addLog("category is blocked");
            }
        }

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.context("NATIVE_APP");
        Log.addLog("Context changed to Native");

        driver.launchApp();


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

    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
