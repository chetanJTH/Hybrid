package Test_Login;

import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Wifi_Off extends Home {
    public Wifi_Off(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void WifiOffTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Login Wifi Off");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);
        WebDriverWait waitForToast = new WebDriverWait(driver,25);


        driver.toggleWifi();
        Log.addLog("Wifi is Off");
        test.log(Status.INFO, "Wifi is Off");

        //    HomePageLogin();

        EmailAddress();

        EnterPassword();

        if(isScreenShot()) {
            captureScreenShot();
        }

        HomePageLogin();

        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
        WebElement toastMessage = (WebElement) driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
        Assert.assertEquals(toastMessage.getText(),"An error occurred! Please check your network connection!");

        Log.addLog("Error message displayed");
        test.log(Status.INFO, "Error message displayed");

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.toggleWifi();
        Log.addLog("Wifi is On");
        test.log(Status.INFO, "Wifi is On");


    }



//    public void HomePageRegister() {
//        loginFactory L = new loginFactory(this.driver);
//        if (L.RegisterButton != null) {
//            L.RegisterButton.isEnabled();
//            Log.addLog("Login Page is visible");
//            test.log(Status.INFO, "Login Page is visible");
//        } else {
//            Log.addLog("Login Page is Not visible");
//            test.log(Status.FAIL, "Login Page is Not visible");
//        }
//    }

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
