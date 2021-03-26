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

public class Unblock_URL extends Home {
    public Unblock_URL(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0234

    @Test
    public void UnblockURLTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Unblock category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);


        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        RemoveBlockWeb();

        Thread.sleep(1500);

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.navigate().back();

        Thread.sleep(1500);

        SupervisionPage();

        wait.until(ExpectedConditions.elementToBeClickable(P.VisionTitle));
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

    public void RemoveBlockWeb() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.RemoveBlockWeb != null) {
            P.RemoveBlockWeb.click();
            Log.addLog("Remove block website button clicked");
            test.log(Status.INFO, "Remove block website button clicked");
        } else {
            Log.addLog("Remove block website button not found");
            test.log(Status.FAIL, "Remove block website button not found");
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
