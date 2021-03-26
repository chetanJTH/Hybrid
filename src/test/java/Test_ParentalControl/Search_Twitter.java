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

public class Search_Twitter extends Home {
    public Search_Twitter(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0233

    @Test
    public void SearchTwitterTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Search udemy.com");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);



        ChromeButton();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);

        }

        driver.context("WEBVIEW_chrome");

        driver.get("http://twitter.com");

        WebElement searchbar = (WebElement) driver.findElement(By.xpath("//*[@id='react-root']"));

        if (searchbar.isDisplayed()) {
//            email.sendKeys("chetan");
            Log.addLog("Twitter home page display");
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
