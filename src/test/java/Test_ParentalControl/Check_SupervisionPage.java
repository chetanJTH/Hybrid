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

public class Check_SupervisionPage extends Home {
    public Check_SupervisionPage(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void CheckSupervisionPageTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check supervision page");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);


        SupervisionPage();

        wait.until(ExpectedConditions.elementToBeClickable(P.VisionTitle));

        if(isScreenShot()) {
            captureScreenShot();
        }



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


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
