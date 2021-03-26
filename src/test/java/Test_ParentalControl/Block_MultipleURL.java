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

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Block_MultipleURL extends Home {
    public Block_MultipleURL(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0236

    @Test
    public void BlockMultipleURLTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block multiple URL");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);

        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        BlockWebsiteButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        BlockFacebook();

        if(isScreenShot()) {
            captureScreenShot();
        }

        BlockWebsiteButton();

        BlockYoutube();

        BlockWebsiteButton();

        BlockInstagram();

        if(isScreenShot()) {
            captureScreenShot();
        }


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

    public void BlockFacebook() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddWebsite != null) {
            P.AddWebsite.sendKeys("www.facebook.com");
            P.AddBlockWeb.click();
            Log.addLog("Website has been blocked");
            test.log(Status.INFO, "Website has been blocked");
        } else {
            Log.addLog("Add website field not visible");
            test.log(Status.FAIL, "Add website field not visible");
        }
    }



    public void BlockYoutube() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddWebsite != null) {
            P.AddWebsite.sendKeys("www.youtube.com");
            P.AddBlockWeb.click();
            Log.addLog("Website has been blocked");
            test.log(Status.INFO, "Website has been blocked");
        } else {
            Log.addLog("Add website field not visible");
            test.log(Status.FAIL, "Add website field not visible");
        }
    }

    public void BlockInstagram() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddWebsite != null) {
            P.AddWebsite.sendKeys("www.instagram.com");
            P.AddBlockWeb.click();
            Log.addLog("Website has been blocked");
            test.log(Status.INFO, "Website has been blocked");
        } else {
            Log.addLog("Add website field not visible");
            test.log(Status.FAIL, "Add website field not visible");
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
