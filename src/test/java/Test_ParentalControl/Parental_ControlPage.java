package Test_ParentalControl;

import PageFactory.SmartHomeFactory;
import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Parental_ControlPage extends Home {
    public Parental_ControlPage(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void ParentalControlPageTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check parental control page");
        test.assignCategory("Regression");
        SmartHomeFactory G = new SmartHomeFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);



//            HomePageLogin();
//
//            EmailAddress();
//
//            EnterPassword();
//
//            HomePageLogin();
//
//        if(isScreenShot()) {
//            captureScreenShot();
//        }

        driver.findElementByXPath("//android.widget.TextView[@text='router v2']").click();

        wait.until(ExpectedConditions.elementToBeClickable(G.AddTool));

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.findElement(By.className("android.widget.ImageButton")).click();
        Log.addLog("Menu button is clickable");
        test.log(Status.INFO, "Menu button is clickable");

        if(isScreenShot()) {
        captureScreenShot();
    }

    ParentalControlButton();

        if(isScreenShot()) {
        captureScreenShot();
    }



}



    public void ParentalControlButton() {
        SmartHomeFactory G = new SmartHomeFactory(driver);
        if (G.ParentalControl != null) {
            G.ParentalControl.click();
            Log.addLog("Parental control button is clicked");
            test.log(Status.INFO, "Parental control button is clicked");
        } else {
            Log.addLog("Parental control button is not visible");
            test.log(Status.FAIL, "Parental control button is not visible");
        }
    }

    public void HomePageLogin() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.click();
            Log.addLog("Login button is clicked");
            test.log(Status.INFO, "Login button is clicked");
        } else {
            Log.addLog("Login button is not visible");
            test.log(Status.FAIL, "Login button is not visible");
        }
    }

    public void EmailAddress() {
        loginFactory L = new loginFactory(this.driver);
        if (L.EmailAddress != null) {
            L.EmailAddress.sendKeys("testing.xunison@gmail.com");
            Log.addLog("Valid email address has been entered");
            test.log(Status.INFO, "Valid email address has been entered");
        } else {
            Log.addLog("Email address field not visible");
            test.log(Status.FAIL, "Email address field not visible");
        }
    }

    public void EnterPassword() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Password != null) {
            L.Password.sendKeys("demo1234");
            Log.addLog("Valid password address has been entered");
            test.log(Status.INFO, "Valid password address has been entered");
        } else {
            Log.addLog("Password field not visible");
            test.log(Status.FAIL, "Password field not visible");
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
