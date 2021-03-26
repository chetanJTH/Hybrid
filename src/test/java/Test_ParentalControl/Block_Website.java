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

public class Block_Website extends Home {
    public Block_Website(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0232

    @Test
    public void BlockWebsiteTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block website");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);


       BlockWebsiteButton();

       if(isScreenShot()) {
            captureScreenShot();
        }

       AddWebsiteButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        AddBlockWebsiteButton();




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

    public void AddWebsiteButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddWebsite != null) {
            P.AddWebsite.sendKeys("www.facebook.com");
            Log.addLog("Website has been entered");
            test.log(Status.INFO, "Website has been entered");
        } else {
            Log.addLog("Add website field not visible");
            test.log(Status.FAIL, "Add website field not visible");
        }
    }

    public void AddBlockWebsiteButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddBlockWeb != null) {
            P.AddBlockWeb.click();
            Log.addLog("Add Block website button clicked");
            test.log(Status.INFO, "Add Block website button clicked");
        } else {
            Log.addLog("Add Block website button not visible");
            test.log(Status.FAIL, "Add Block website button not visible");
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
