package Test_Login;

import PageFactory.loginFactory;
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

public class Home_Page extends Home {

    public Home_Page(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    //TC0059

    @Test
    public void HomePageTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Home Page");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);

        wait.until(ExpectedConditions.elementToBeClickable(L.HomePage));

        HomePage();

        if(isScreenShot()) {
            captureScreenShot();
        }





    }

    public void HomePage() {
        loginFactory L = new loginFactory(this.driver);
        if (L.HomePage != null) {
            L.HomePage.isDisplayed();
            Log.addLog("Home page is visible");
            test.log(Status.INFO, "Home page is visible");
        } else {
            Log.addLog("Home page is not visible");
            test.log(Status.FAIL, "Home page is not visible");
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
