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

public class Check_PieChart extends Home {
    public Check_PieChart(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    //TC0218

    @Test
    public void CheckPieChartTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check pie chart");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);


        wait.until(ExpectedConditions.elementToBeClickable(P.Chart));

        if (isScreenShot()) {
            captureScreenShot();
        }

        ChartView();
    }


    public void ChartView() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.Chart != null) {
            P.Chart.isDisplayed();
            Log.addLog("Pie chart display");
            test.log(Status.INFO, "Pie chart display");
        } else {
            Log.addLog("Pie chart does not display");
            test.log(Status.FAIL, "Pie chart does not display");
        }
    }


    public static void captureScreenShot() {
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
