package Test_Login;

import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Forgot_Password1 extends Home {
    public Forgot_Password1(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    @Test
    public void ForgotPasswordTest1() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Forgot Password Link");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);

        //TC0060

        HomePageLogin();

        ForgotpassowrdLink();

        if(isScreenShot()) {
            captureScreenShot();
        }

        L.EmailAddress.sendKeys("abc");
        Log.addLog("InValid email address has been entered");
        test.log(Status.INFO, "InValid email address has been entered");

        SendEmailButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        WebElement result = (WebElement) driver.findElement(By.id("xunison.com.smarthomeapp:id/textinput_error"));
        Assert.assertEquals(result.getText(),"Email is invalid");

        Log.addLog("Error displayed");
        test.log(Status.INFO, "Error Displayed");

        if(isScreenShot()) {
            captureScreenShot();
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

    public void ForgotpassowrdLink() {
        loginFactory L = new loginFactory(this.driver);
        if (L.ForgotPassword != null) {
            L.ForgotPassword.click();
            Log.addLog("Forgot password link is clicked");
            test.log(Status.INFO, "Forgot password link is clicked");
        } else {
            Log.addLog("Forgot password link is not visible");
            test.log(Status.FAIL, "Forgot password link is not visible");
        }
    }

    public void SendEmailButton() {
        loginFactory L = new loginFactory(this.driver);
        if (L.SendEmail != null) {
            L.SendEmail.click();
            Log.addLog("Send email button is clicked");
            test.log(Status.INFO, "Send email button is clicked");
        } else {
            Log.addLog("Send email button is not visible");
            test.log(Status.FAIL, "Send email button is not visible");
        }
    }


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
