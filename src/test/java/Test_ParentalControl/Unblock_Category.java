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

public class Unblock_Category extends Home {
    public Unblock_Category(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0234

    @Test
    public void UnblockCategoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Unblock category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);


        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        RemoveBlockCat();

        if(isScreenShot()) {
            captureScreenShot();
        }

    }



    public void RemoveBlockCat() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.RemoveBlockCat != null) {
            P.RemoveBlockCat.click();
            Log.addLog("Remove block category button clicked");
            test.log(Status.INFO, "Remove block category button clicked");
        } else {
            Log.addLog("Remove block category button not found");
            test.log(Status.FAIL, "Remove block category button not found");
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
